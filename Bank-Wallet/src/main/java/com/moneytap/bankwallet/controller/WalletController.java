package com.moneytap.bankwallet.controller;

import com.moneytap.bankwallet.exception.UserNotFoundException;
import com.moneytap.bankwallet.exception.WalletNotFoundException;
import com.moneytap.bankwallet.model.BankAccount;
import com.moneytap.bankwallet.model.Wallet;
import com.moneytap.bankwallet.service.JwtResponseService;
import com.moneytap.bankwallet.service.WalletService;
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
    public void createWallet(@PathVariable int walletBalance,@RequestHeader("Authorization") String token){
        try{
            jwtResponseService.checkTokenExists(token);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Wallet wallet=new Wallet(walletBalance);
        walletService.addWallet(wallet);
    }

    @GetMapping(value = "/show/{walletId}")
    public Wallet getWalletById(@PathVariable int walletId,@RequestHeader("Authorization") String token){
        Wallet wallet=new Wallet();
        try{
            jwtResponseService.checkTokenExists(token);


                wallet= walletService.getWalletById(walletId);



        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }catch (WalletNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return wallet;
    }

    @RequestMapping(value = "/delete")
    public void deleteWallet(@RequestBody Wallet wallet,@RequestHeader("Authorization") String token){
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
