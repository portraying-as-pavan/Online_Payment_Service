package com.moneytap.customerservice.controller;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moneytap.customerservice.exception.CustomerNotFoundException;
import com.moneytap.customerservice.exception.UserNotFoundException;
import com.moneytap.customerservice.model.Customer;
import com.moneytap.customerservice.model.JwtRequest;
import com.moneytap.customerservice.model.JwtResponse;
import com.moneytap.customerservice.model.Wallet;
import com.moneytap.customerservice.service.CustomerService;
import com.moneytap.customerservice.service.JwtResponseService;
import com.moneytap.customerservice.service.UserService;
import com.moneytap.customerservice.service.WalletService;
import com.moneytap.customerservice.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private WalletService walletService;

    @PostMapping(value = "/add/{customerName}/{mobileNumber}/{password}/{walletBalance}")
    public void addCustomer(@PathVariable String customerName, @PathVariable String mobileNumber,
                            @PathVariable String password, @PathVariable int walletBalance){
      //  String walletUrl="http:localhost:8081/wallet/add";
        Wallet wallet=new Wallet(walletBalance);
        Customer customer=new Customer(customerName,mobileNumber,password,wallet);
            walletService.addWallet(wallet);
        customerService.addCustomer(customer);
    }
    @GetMapping(value = "/show/{customerId}")
    public Customer getCustomerById(@PathVariable int customerId,@RequestHeader("Authorization") String token){


        Customer customer=new Customer();
        try {
           customer=customerService.getCustomerById(customerId);
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }

    @GetMapping(value = "/delete")
    public void deleteCustomer(@RequestBody Customer customer){
        customerService.deleteCustomer(customer);
    }

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtResponseService jwtResponseService;



    @PostMapping("/authenticate")
    @JsonIgnore
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token =
                jwtUtility.generateToken(userDetails);

        JwtResponse response= new JwtResponse(token);
        jwtResponseService.addToken(response);
        return response;
    }

    @RequestMapping(value = "/logOut")
    public void loggingOut(@RequestBody JwtResponse response, @RequestHeader("Authorization") String token){
        try{
            jwtResponseService.checkTokenExists(token);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        jwtResponseService.deleteToken(response);
    }
}
