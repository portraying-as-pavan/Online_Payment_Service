package com.moneytap.bankwallet.repository;

import com.moneytap.bankwallet.model.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<Wallet,Integer> {
}
