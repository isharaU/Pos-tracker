package lk.hsenid.pos.sales.tracker.controller;

import lk.hsenid.pos.sales.tracker.entity.Sale;
import lk.hsenid.pos.sales.tracker.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    // 🎯 1. Record a sale
    @PostMapping
    public ResponseEntity<Sale> recordSale(@RequestBody Sale sale) {
        Sale savedSale = saleService.recordSale(sale);
        return ResponseEntity.ok(savedSale);
    }

    // 🎯 2. Get all sales (optional — useful for debug/testing)
    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }
}
