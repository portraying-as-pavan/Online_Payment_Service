package com.moneytap.bankwallet.service;



import com.moneytap.bankwallet.exception.CustomerNotFoundException;
import com.moneytap.bankwallet.model.Customer;


import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    Customer getCustomerById(int id) throws CustomerNotFoundException;
    List<Customer> getAllCustomers();
    void deleteCustomer(Customer customer);
    Customer getCustomerByName(String name) throws CustomerNotFoundException;
}
