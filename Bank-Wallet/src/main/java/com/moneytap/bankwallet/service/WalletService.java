package com.moneytap.bankwallet.service;

import com.moneytap.bankwallet.exception.WalletNotFoundException;
import com.moneytap.bankwallet.model.BankAccount;
import com.moneytap.bankwallet.model.Wallet;

public interface WalletService {
   void addWallet(Wallet wallet);
    Wallet getWalletById(int id) throws WalletNotFoundException;
    void  deleteWallet(Wallet wallet);
  //  void linkBankAccount(BankAccount bankAccount,Wallet wallet);

}
