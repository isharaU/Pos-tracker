package lk.hsenid.pos.sales.tracker.service;

import lk.hsenid.pos.sales.tracker.entity.Sale;
import lk.hsenid.pos.sales.tracker.entity.SalesSummary;
import lk.hsenid.pos.sales.tracker.entity.Store;
import lk.hsenid.pos.sales.tracker.repository.SaleRepository;
import lk.hsenid.pos.sales.tracker.repository.SalesSummaryRepository;
import lk.hsenid.pos.sales.tracker.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesSummaryService {
    private final SaleRepository saleRepository;
    private final SalesSummaryRepository summaryRepository;
    private final StoreRepository storeRepository;

    // Run this every hour
    @Scheduled(cron = "0 0 * * * *") // Top of every hour
    public void generateHourlySummaries() {
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS);
        LocalDateTime oneHourAgo = now.minusHours(1);

        for (Store store : storeRepository.findAll()) {
            List<Sale> sales = saleRepository.findByStoreIdAndTimestampBetween(
                    store.getId(), oneHourAgo, now);

            double total = sales.stream()
                    .mapToDouble(sale -> sale.getQuantity() * sale.getProduct().getPrice())
                    .sum();

            SalesSummary summary = new SalesSummary();
            summary.setStore(store);
            summary.setHour(oneHourAgo);
            summary.setTotalSalesAmount(total);
            summary.setCreatedAt(LocalDateTime.now());

            summaryRepository.save(summary);
        }
    }

    public List<SalesSummary> getSummaries(Long storeId, LocalDateTime hour) {
        return summaryRepository.findByStoreIdAndHour(storeId, hour);
    }
}
