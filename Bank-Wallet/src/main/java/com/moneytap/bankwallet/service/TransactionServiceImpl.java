package com.moneytap.bankwallet.service;

import com.moneytap.bankwallet.exception.TransactionNotFoundException;
import com.moneytap.bankwallet.model.Transaction;
import com.moneytap.bankwallet.model.Wallet;
import com.moneytap.bankwallet.repository.TransactionRepository;
import com.moneytap.bankwallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private WalletRepository walletRepository;


    @Override
    public void addTransaction(Transaction transaction, Wallet receiver) {
      //  Wallet receiver=beneficiary.getWallet();

          Wallet sender =transaction.getWallet();
          if(transaction.getTransaction_type().equals("debit")){
              if(sender.getWalletBalance()<transaction.getAmount())
              {
                //  System.out.println("sender balance= "+ sender.getWalletBalance());
                //  System.out.println("transaction amount= "+transaction.getAmount());
                  transaction.setStatus("failed");
                  transaction.setDescription("Failed Due to insufficient Funds");
                ///  System.out.println("Status set to failed");
              }
              else {
                  sender.setWalletBalance(sender.getWalletBalance()-transaction.getAmount());
                  receiver.setWalletBalance(receiver.getWalletBalance()+transaction.getAmount());
                  walletRepository.save(sender);
                  walletRepository.save(receiver);
                  transaction.setStatus("Success");
                //  System.out.println("transaction status set to sucess");
                  // transactionRepository.save(transaction);
              }
          }
          else {
              receiver.setWalletBalance(receiver.getWalletBalance()+transaction.getAmount());
              walletRepository.save(receiver);
              transaction.setStatus("Success");
              //  transactionRepository.save(transaction);
          }
          transactionRepository.save(transaction);
          //  transactionRepository.save(transaction);

    }

    @Override
    public Transaction getTransaction(int id) throws TransactionNotFoundException {

        Transaction transaction=null;
        try {
            transaction = transactionRepository.findById(id).get();
        }catch (NoSuchElementException n){
            throw  new TransactionNotFoundException("Transaction Not found");
        }
        return transaction;

    }

    @Override
    public List<Transaction> getAllTransactions() {
        return (List<Transaction>) transactionRepository.findAll();
    }
/*
    @Override
    public Transaction getTransactionsByDate(LocalDate date) {
        return transactionRepository.getTransactionsByDateEquals(date);
    }

    @Override
    public Transaction getTransactionsByTransaction_typeEquals(String type) {
        return transactionRepository.getTransactionsByTypeEquals(type);
    }

 */
/*
    @Override
    public List<Transaction> getTransactionsByDate(LocalDate date) {
        return transactionRepository.getTransactionByTransactionDateEquals(date);
    }

    @Override
    public List<Transaction> getTransactionsByType(String type) {
        return  transactionRepository.getTransactionByTransaction_typeEquals(type);
    }

 */
}
