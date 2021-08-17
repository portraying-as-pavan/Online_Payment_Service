package com.moneytap.bankwallet.service;

import com.moneytap.bankwallet.exception.TransactionNotFoundException;
import com.moneytap.bankwallet.model.Transaction;
import com.moneytap.bankwallet.model.Wallet;

import java.util.List;

public interface TransactionService {
    void addTransaction(Transaction transaction, Wallet receiver);
    Transaction getTransaction(int id) throws TransactionNotFoundException;
    List<Transaction> getAllTransactions();
 //   Transaction getTransactionsByDate(LocalDate date);
//    Transaction getTransactionsByTransaction_typeEquals(String type);
   // List<Transaction> getTransactionsByDate(LocalDate date);
   // List<Transaction> getTransactionsByType(String type);
}
