package com.moneytap.customerservice.controller;


import com.moneytap.customerservice.exception.CustomerNotFoundException;
import com.moneytap.customerservice.exception.UserNotFoundException;
import com.moneytap.customerservice.model.BankAccount;
import com.moneytap.customerservice.model.Wallet;
import com.moneytap.customerservice.service.BankAccountService;
import com.moneytap.customerservice.service.JwtResponseService;
import com.moneytap.customerservice.service.WalletService;
import com.moneytap.customerservice.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.Path;

@RestController
@RequestMapping(value = "/bankaccount")
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private WalletService walletService;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private JwtResponseService jwtResponseService;

    @PostMapping(value = "/add/{bankName}/{ifsc}/{bankBalance}/{walletBalance}")
    public void createAccount(@PathVariable String bankName, @PathVariable String ifsc,
                              @PathVariable int bankBalance,
                              @PathVariable int walletBalance, @RequestHeader("Authorization") String token) throws UserNotFoundException {

        if(jwtResponseService.checkTokenExists(token)) {

            String walletUrl = "http://transaction-service/wallet/add/";
            Wallet wallet = new Wallet(walletBalance);
            //  walletService.addWallet(wallet);
            restTemplate.postForObject(walletUrl + walletBalance, wallet, Wallet.class);
            BankAccount bankAccount = new BankAccount(ifsc, bankName, bankBalance);
            bankAccount.setWallet(wallet);

            bankAccountService.addBankAccount(bankAccount);
        }
        else {
            throw new UserNotFoundException("Please Login in");
        }
    }

    @GetMapping(value = "/check/{id}")
    public Wallet getWallet(@PathVariable int id,@RequestHeader("Authorization") String token) throws UserNotFoundException {

       // String uName=jwtUtility.getUsernameFromToken(token);
      //  System.out.println(uName);
        Wallet wallet=null;
        if(jwtResponseService.checkTokenExists(token)) {

            String walletUrl = "http://transaction-service/wallet/show/";
             wallet = restTemplate.getForObject(walletUrl + id, Wallet.class);
            return wallet;
        }
        else{
            throw  new UserNotFoundException("Please Login");
        }
    }
    @GetMapping(value = "/show/{accNo}")
    public BankAccount getAccountById(@PathVariable int accNo,@RequestHeader("Authorization") String token) throws UserNotFoundException {
        BankAccount bankAccount=null;
        if(jwtResponseService.checkTokenExists(token)) {
            bankAccount= bankAccountService.showBankAccountById(accNo);
        }else{
            throw new UserNotFoundException("Please Login!");
        }
        return  bankAccount;
    }

    @RequestMapping(value = "/delete")
    public void deleteBankAccount(@RequestBody BankAccount bankAccount,@RequestHeader("Authorization") String token) throws UserNotFoundException {
        if(jwtResponseService.checkTokenExists(token)) {
            bankAccountService.removeBankAccount(bankAccount);
        }
        else {
            throw new UserNotFoundException("Please Login!");
        }
    }
}
