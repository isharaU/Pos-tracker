package lk.hsenid.pos.sales.tracker.controller;

import lk.hsenid.pos.sales.tracker.entity.SalesSummary;
import lk.hsenid.pos.sales.tracker.service.SalesSummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/summaries")
@RequiredArgsConstructor
public class SalesSummaryController {

    private final SalesSummaryService summaryService;

    // Get hourly summary for a specific store and hour
    @GetMapping
    public ResponseEntity<List<SalesSummary>> getSummary(
            @RequestParam Long storeId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hour
    ) {
        List<SalesSummary> summaries = summaryService.getSummaries(storeId, hour);
        return ResponseEntity.ok(summaries);
    }
}
