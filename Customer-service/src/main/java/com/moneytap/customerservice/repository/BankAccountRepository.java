package com.moneytap.customerservice.repository;


import com.moneytap.customerservice.model.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount,Integer> {
}
