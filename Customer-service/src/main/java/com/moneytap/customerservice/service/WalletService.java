package com.moneytap.customerservice.service;


import com.moneytap.customerservice.model.Wallet;

public interface WalletService {
   void addWallet(Wallet wallet);
    Wallet getWalletById(int id);
    void  deleteWallet(Wallet wallet);
  //  void linkBankAccount(BankAccount bankAccount,Wallet wallet);

}
