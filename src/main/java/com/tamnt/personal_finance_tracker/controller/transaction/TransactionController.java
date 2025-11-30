package com.tamnt.personal_finance_tracker.controller.transaction;

import com.tamnt.personal_finance_tracker.model.Transaction;
import com.tamnt.personal_finance_tracker.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public ResponseEntity<List> getAllUserTransactions() {
        Long currentUserId = 1L;

        List<Transaction> transactions = transactionService.findAllTransactionByUserId(currentUserId);

        return ResponseEntity.ok(transactions);
    }
}
