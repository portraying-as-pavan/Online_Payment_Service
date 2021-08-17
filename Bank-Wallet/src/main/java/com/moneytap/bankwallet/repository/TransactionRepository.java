package com.moneytap.bankwallet.repository;

import com.moneytap.bankwallet.model.Transaction;
import com.moneytap.bankwallet.service.TransactionService;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction,Integer> {

//    List<Transaction> getTransactionByTransactionDateEquals(LocalDate date);
 //   List<Transaction> getTransactionByTransaction_typeEquals(String type);

  //  Transaction getTransactionsByDateEquals(LocalDate date);
 //   Transaction getTransactionsByTypeEquals(String type);
}
