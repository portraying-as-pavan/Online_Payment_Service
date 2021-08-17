package com.moneytap.customerservice.exception;

public class BeneficiaryNotFoundException extends Exception{
    public BeneficiaryNotFoundException() {
    }

    public BeneficiaryNotFoundException(String message) {
        super(message);
    }
}
