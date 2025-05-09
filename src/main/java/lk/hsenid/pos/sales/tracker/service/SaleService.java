package lk.hsenid.pos.sales.tracker.service;

import lk.hsenid.pos.sales.tracker.entity.Product;
import lk.hsenid.pos.sales.tracker.entity.Sale;
import lk.hsenid.pos.sales.tracker.entity.Store;
import lk.hsenid.pos.sales.tracker.repository.ProductRepository;
import lk.hsenid.pos.sales.tracker.repository.SaleRepository;
import lk.hsenid.pos.sales.tracker.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;

    public void recordSale(Long storeId, Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Not enough stock");
        }

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        // Reduce product quantity
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);

        // Save sale
        Sale sale = new Sale();
        sale.setStore(store);
        sale.setProduct(product);
        sale.setQuantity(quantity);
        sale.setTimestamp(LocalDateTime.now());

        saleRepository.save(sale);
    }

    public List<Sale> getAllSales() {
        return new ArrayList<>();
    }

    public Sale recordSale(Sale sale) {
        return sale;
    }
}
