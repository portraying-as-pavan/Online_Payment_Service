package com.moneytap.bankwallet.repository;

import com.moneytap.bankwallet.model.BillPayment;
import org.springframework.data.repository.CrudRepository;

public interface BillPaymentRepository extends CrudRepository<BillPayment,Integer> {
}
