package com.moneytap.customerservice.service;



import com.moneytap.customerservice.exception.CustomerNotFoundException;
import com.moneytap.customerservice.model.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    Customer getCustomerById(int id) throws CustomerNotFoundException;
    List<Customer> getAllCustomers();
    void deleteCustomer(Customer customer);
    Customer getCustomerByName(String name) throws CustomerNotFoundException;
}
