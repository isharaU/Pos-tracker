package lk.hsenid.pos.sales.tracker.repository;

import lk.hsenid.pos.sales.tracker.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByStoreIdAndTimestampBetween(Long storeId, LocalDateTime start, LocalDateTime end);
}
