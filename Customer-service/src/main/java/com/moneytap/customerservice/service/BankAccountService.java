package com.moneytap.customerservice.service;


import com.moneytap.customerservice.model.BankAccount;

public interface BankAccountService {
    void addBankAccount(BankAccount bankAccount);
    BankAccount showBankAccountById(int id);
    void removeBankAccount(BankAccount bankAccount);
}
