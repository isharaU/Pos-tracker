package lk.hsenid.pos.sales.tracker.repository;

import lk.hsenid.pos.sales.tracker.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
