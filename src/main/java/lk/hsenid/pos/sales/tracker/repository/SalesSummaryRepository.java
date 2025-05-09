package lk.hsenid.pos.sales.tracker.repository;

import lk.hsenid.pos.sales.tracker.entity.SalesSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SalesSummaryRepository extends JpaRepository<SalesSummary, Long> {
    List<SalesSummary> findByStoreIdAndHour(Long storeId, LocalDateTime hour);
}
