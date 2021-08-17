package com.moneytap.customerservice.repository;


import com.moneytap.customerservice.model.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<Wallet,Integer> {
}
