package com.moneytap.customerservice.repository;

;
import com.moneytap.customerservice.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    Customer getCustomerByNameEquals(String name);
}
