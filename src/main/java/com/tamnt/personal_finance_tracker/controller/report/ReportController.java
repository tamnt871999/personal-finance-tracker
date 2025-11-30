package com.tamnt.personal_finance_tracker.controller.report;

import com.tamnt.personal_finance_tracker.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final TransactionService transactionService;

    public ReportController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/summary")
    public ResponseEntity<Map<String,Double>> getSummaryReport() {

        Long currentUserId = 1L;

        // 0 = Expense, 1 = Income
        Double totalIncome = transactionService.calculateTotal(currentUserId,1);
        Double totalExpense = transactionService.calculateTotal(currentUserId,0);

        Map<String,Double> summary = Map.of(
                "income" , totalIncome,
                "expense", totalExpense,
                "balance", totalIncome - totalExpense
        );

        return ResponseEntity.ok(summary);
    }
}
