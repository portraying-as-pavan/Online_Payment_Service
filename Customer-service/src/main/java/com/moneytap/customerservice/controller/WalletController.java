package com.moneytap.customerservice.controller;


import com.moneytap.customerservice.exception.UserNotFoundException;
import com.moneytap.customerservice.model.Wallet;
import com.moneytap.customerservice.service.JwtResponseService;
import com.moneytap.customerservice.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private JwtResponseService jwtResponseService;

    @PostMapping(value = "/add/{walletBalance}")
    public void createWallet(@PathVariable int walletBalance){
        Wallet wallet=new Wallet(walletBalance);
        walletService.addWallet(wallet);
    }

    @GetMapping(value = "/show/{walletId}")
    public Wallet getWalletById(@PathVariable int walletId, @RequestHeader("Authorization") String token){
        try{
            jwtResponseService.checkTokenExists(token);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return walletService.getWalletById(walletId);
    }

    @RequestMapping(value = "/delete")
    public void deleteWallet(@RequestBody Wallet wallet, @RequestHeader("Authorization") String token){
        try{
            jwtResponseService.checkTokenExists(token);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        walletService.deleteWallet(wallet);
    }
/*
    @PostMapping(value = "/linkbank")
    public void linkBankToWallet(@RequestBody BankAccount bankAccount, @RequestBody Wallet wallet){
        walletService.linkBankAccount(bankAccount,wallet);
    }

 */
}
