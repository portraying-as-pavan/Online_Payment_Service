package com.moneytap.bankwallet.service;

import com.moneytap.bankwallet.model.BillPayment;
import com.moneytap.bankwallet.model.Wallet;
import com.moneytap.bankwallet.repository.BillPaymentRepository;
import com.moneytap.bankwallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService{
    @Autowired
    private BillPaymentRepository billPaymentRepository;
    @Autowired
    private WalletRepository walletRepository;
    @Override
    public void addBill(BillPayment billPayment) {

        Wallet wallet=billPayment.getWallet();

        if(billPayment.getAmount()>wallet.getWalletBalance())
        {
            billPayment.setStatus("Failed");
            billPayment.setDescription("Failed due to insufficient Funds");


        }else{
            billPayment.setStatus("Success");
            wallet.setWalletBalance(wallet.getWalletBalance()-billPayment.getAmount());
            walletRepository.save(wallet);
        }
        billPaymentRepository.save(billPayment);
    }

    @Override
    public BillPayment getBillPayment(int id) {
        return billPaymentRepository.findById(id).get();
    }
}
