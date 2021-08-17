package com.moneytap.bankwallet.exception;

public class BeneficiaryNotFoundException extends Exception{
    public BeneficiaryNotFoundException() {
    }

    public BeneficiaryNotFoundException(String message) {
        super(message);
    }
}
