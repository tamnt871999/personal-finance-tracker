package com.tamnt.personal_finance_tracker.controller.transaction;

import com.tamnt.personal_finance_tracker.model.Transaction;
import com.tamnt.personal_finance_tracker.model.User;
import com.tamnt.personal_finance_tracker.service.TransactionService;
import com.tamnt.personal_finance_tracker.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final UserService userService;

    public TransactionController(TransactionService transactionService,UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }

    public ResponseEntity<List<Transaction>> getAllUserTransactions() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User currentUser = userService.findByUserName(userName);

        List<Transaction> transactions = transactionService.findAllTransactionByUserId(currentUser.getId());

        return ResponseEntity.ok(transactions);
    }
}
