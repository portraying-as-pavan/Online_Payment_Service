package com.moneytap.bankwallet.service;

import com.moneytap.bankwallet.exception.CustomerNotFoundException;
import com.moneytap.bankwallet.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //Logic to get the user form the Database

        Customer customer=null;
        try {
            customer=customerService.getCustomerByName(userName);
        }catch (CustomerNotFoundException c){
            System.out.println(c.getMessage());
        }

        System.out.println(customer);
        String passwd=customer.getPassword();



       // return new User("admin","passwd",new ArrayList<>());
        return new User(userName,passwd,new ArrayList<>());
    }
}
