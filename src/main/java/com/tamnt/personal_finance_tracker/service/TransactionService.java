package com.tamnt.personal_finance_tracker.service;

import com.tamnt.personal_finance_tracker.model.Transaction;
import com.tamnt.personal_finance_tracker.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    public final TransactionRepository transactionRepositoty;

    public TransactionService(TransactionRepository transactionRepositoty) {
        this.transactionRepositoty = transactionRepositoty;
    }

    public List<Transaction> findAllTransactionByUserId(Long userId) {
        return transactionRepositoty.findAllByUserId(userId);
    }

    public Double calculateTotal(Long userId, int type) {
        return transactionRepositoty.sumAmountByUserIdAndCategoryType(userId, type) != null ?
                transactionRepositoty.sumAmountByUserIdAndCategoryType(userId, type) : 0.0;
    }
}
