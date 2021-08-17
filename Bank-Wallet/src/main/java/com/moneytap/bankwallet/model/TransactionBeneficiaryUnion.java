package com.moneytap.bankwallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class TransactionBeneficiaryUnion {
    private Beneficiary beneficiary;
    private  Transaction transaction;
}
