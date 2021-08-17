package com.moneytap.bankwallet.service;

import com.moneytap.bankwallet.exception.WalletNotFoundException;
import com.moneytap.bankwallet.model.BankAccount;
import com.moneytap.bankwallet.model.Wallet;
import com.moneytap.bankwallet.repository.WalletRepository;
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
    public Wallet getWalletById(int id) throws WalletNotFoundException {
        Wallet wallet=walletRepository.findById(id).get();
        if(wallet==null){
            throw new WalletNotFoundException("Wallet with id "+id+" not found");
        }
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
