package com.moneytap.customerservice.service;


import com.moneytap.customerservice.model.Wallet;
import com.moneytap.customerservice.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService{

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public void addWallet(Wallet wallet) {
       walletRepository.save(wallet);
    }

    @Override
    public Wallet getWalletById(int id) {
        Wallet wallet=walletRepository.findById(id).get();
        return wallet;
    }

    @Override
    public void deleteWallet(Wallet wallet) {
        walletRepository.delete(wallet);
    }
/*
    @Override
    public void linkBankAccount(BankAccount bankAccount, Wallet wallet) {
        wallet.getBankAccountList().add(bankAccount);
        walletRepository.save(wallet);
    }

 */
}
