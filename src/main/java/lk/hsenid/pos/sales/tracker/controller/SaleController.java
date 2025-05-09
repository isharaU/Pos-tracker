package lk.hsenid.pos.sales.tracker.controller;

import lk.hsenid.pos.sales.tracker.entity.Sale;
import lk.hsenid.pos.sales.tracker.service.SaleService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    // Record sale using storeId, productId, quantity
    @PostMapping("/simple")
    public ResponseEntity<String> recordSimpleSale(@RequestBody SaleRequest request) {
        saleService.recordSale(request.getStoreId(), request.getProductId(), request.getQuantity());
        return ResponseEntity.ok("Sale recorded successfully.");
    }

    // Record sale using full Sale object
    @PostMapping
    public ResponseEntity<Sale> recordSale(@RequestBody Sale sale) {
        Sale saved = saleService.recordSale(sale);
        return ResponseEntity.ok(saved);
    }

    // Get all sales
    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    // DTO for simple sale input
    @Data
    public static class SaleRequest {
        private Long storeId;
        private Long productId;
        private int quantity;
    }
}
