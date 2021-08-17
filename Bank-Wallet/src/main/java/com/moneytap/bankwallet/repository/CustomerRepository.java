package com.moneytap.bankwallet.repository;

import com.moneytap.bankwallet.model.Customer;

import org.springframework.data.repository.CrudRepository;

;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    Customer getCustomerByNameEquals(String name);
}
