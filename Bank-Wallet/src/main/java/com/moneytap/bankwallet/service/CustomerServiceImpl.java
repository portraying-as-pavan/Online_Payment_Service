package com.moneytap.bankwallet.service;



import com.moneytap.bankwallet.exception.CustomerNotFoundException;
import com.moneytap.bankwallet.model.Customer;
import com.moneytap.bankwallet.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(int id) throws CustomerNotFoundException {
        Customer customer=null;
        try {
           customer = customerRepository.findById(id).get();
        }catch (Exception e){
            throw new CustomerNotFoundException("Customer with id "+id+" is not found!");
        }
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(Customer customer) {
            customerRepository.delete(customer);
    }

    @Override
    public Customer getCustomerByName(String name) throws CustomerNotFoundException {
       Customer customer = customerRepository.getCustomerByNameEquals(name);
      if(customer==null){
          throw new CustomerNotFoundException("Customer with name "+name+" not found");
      }
      return customer;
    }


}
