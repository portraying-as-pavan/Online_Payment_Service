package com.moneytap.bankwallet.controller;

import com.moneytap.bankwallet.exception.TransactionNotFoundException;
import com.moneytap.bankwallet.exception.UserNotFoundException;
import com.moneytap.bankwallet.exception.WalletNotFoundException;
import com.moneytap.bankwallet.model.Beneficiary;
import com.moneytap.bankwallet.model.Transaction;

import com.moneytap.bankwallet.model.Wallet;
import com.moneytap.bankwallet.service.JwtResponseService;
import com.moneytap.bankwallet.service.TransactionService;
import com.moneytap.bankwallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private WalletService walletService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private JwtResponseService jwtResponseService;

    @PostMapping(value = "/add/{senderWalletId}/{beneficiaryid}/{amount}/{desc}")
    public void addTransaction(@PathVariable int senderWalletId,
                               @PathVariable int beneficiaryid, @PathVariable int amount,
                               @PathVariable String desc, @RequestHeader("Authorization") String token){
        try{
            jwtResponseService.checkTokenExists(token);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        String beneficiaryUrl="http://customer-service/beneficiary/show/";

        Transaction transaction=new Transaction(amount,desc);
        transaction.setTransaction_type("debit");
        Wallet receiver=null,sender=null;
        try {
            sender=walletService.getWalletById(senderWalletId);
            transaction.setWallet(sender);

        }catch (WalletNotFoundException w){
            System.out.println(w.getMessage());
        }

     //   Transaction transaction=transactionBeneficiaryUnion.getTransaction();
      //  Beneficiary beneficiary= transactionBeneficiaryUnion.getBeneficiary();
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization",token);

        HttpEntity<Beneficiary> entity = new HttpEntity<>( headers);


        try {
           // Beneficiary beneficiary = restTemplate.getForObject(beneficiaryUrl + beneficiaryid, Beneficiary.class);
            ResponseEntity<Beneficiary> s= restTemplate.exchange(beneficiaryUrl+beneficiaryid, HttpMethod.POST, entity, Beneficiary.class);
            receiver=s.getBody().getWallet();
         // receiver = beneficiary.getWallet();
            transactionService.addTransaction(transaction,receiver);
        }catch (NullPointerException n){
            System.out.println(n.getMessage());
        }

    }

    @GetMapping(value = "/show/id/{transactionId}")
    public Transaction getTransById(@PathVariable int transactionId,@RequestHeader("Authorization") String token){
        try{
            jwtResponseService.checkTokenExists(token);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Transaction trans=null;
        try {
            trans= transactionService.getTransaction(transactionId);
        }catch (TransactionNotFoundException e){
            System.out.println(e.getMessage());
        }
        return trans;
    }
/*
    @GetMapping(value = "/show/date/{date}")
    public List<Transaction> getTransByDate(@PathVariable LocalDate date){
        return transactionService.getTransactionsByDate(date);
    }
    @GetMapping(value = "/show/type/{type}")
    public List<Transaction> getTransByDate(@PathVariable String type){
        return transactionService.getTransactionsByType(type);
    }

 */

}
