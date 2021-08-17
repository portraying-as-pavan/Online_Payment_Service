package com.moneytap.bankwallet.controller;

import com.moneytap.bankwallet.exception.UserNotFoundException;
import com.moneytap.bankwallet.model.BillPayment;
import com.moneytap.bankwallet.model.Wallet;
import com.moneytap.bankwallet.service.BillService;
import com.moneytap.bankwallet.service.JwtResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/bill")
public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private JwtResponseService jwtResponseService;

    @PostMapping(value = "/add/{amount}/{type}/{desc}/{senderWalletId}")
    public void addBill(@PathVariable int amount, @PathVariable String type,
                        @PathVariable String desc, @PathVariable int senderWalletId, @RequestHeader("Authorization") String token){

        try{
            jwtResponseService.checkTokenExists(token);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }

     //   String walletUrl="http://localhost:8082/wallet/show/";
        String walletUrl="http://customer-service/wallet/show/";
        Wallet wallet=restTemplate.getForObject(walletUrl+senderWalletId,Wallet.class);

        BillPayment bill=new BillPayment(type,desc,amount);
        bill.setWallet(wallet);
        billService.addBill(bill);
    }

    @GetMapping(value = "/show/{billId}")
    public BillPayment showBillById(@PathVariable int billId,@RequestHeader("Authorization") String token){
        try{
            jwtResponseService.checkTokenExists(token);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return billService.getBillPayment(billId);
    }
}
