package com.moneytap.bankwallet.service;

import com.moneytap.bankwallet.model.BillPayment;

public interface BillService {
    void addBill(BillPayment billPayment);
    BillPayment getBillPayment(int id);

}
