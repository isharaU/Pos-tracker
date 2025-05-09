package lk.hsenid.pos.sales.tracker.repository;

import lk.hsenid.pos.sales.tracker.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
