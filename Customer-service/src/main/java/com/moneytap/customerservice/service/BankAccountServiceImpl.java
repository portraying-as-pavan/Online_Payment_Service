package com.moneytap.customerservice.service;


import com.moneytap.customerservice.model.BankAccount;
import com.moneytap.customerservice.service.BankAccountService;
import com.moneytap.customerservice.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public void addBankAccount(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public BankAccount showBankAccountById(int id) {
      BankAccount bankAccount=  bankAccountRepository.findById(id).get();
      return bankAccount;
    }

    @Override
    public void removeBankAccount(BankAccount bankAccount) {
            bankAccountRepository.delete(bankAccount);
    }
}
