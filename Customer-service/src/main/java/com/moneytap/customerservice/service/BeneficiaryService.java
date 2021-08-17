package com.moneytap.customerservice.service;



import com.moneytap.customerservice.model.Beneficiary;

import java.util.List;

public interface BeneficiaryService {
    void addBeneficiary(Beneficiary beneficiary);
    void deleteBeneficiary(Beneficiary beneficiary);
    Beneficiary getBeneficiaryById(int id);
    List<Beneficiary> getBeneficiaries();
}
