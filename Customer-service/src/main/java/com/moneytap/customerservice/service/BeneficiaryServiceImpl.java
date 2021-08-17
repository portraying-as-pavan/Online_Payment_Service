package com.moneytap.customerservice.service;


import com.moneytap.customerservice.model.Beneficiary;
import com.moneytap.customerservice.repository.BeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {
    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @Override
    public void addBeneficiary(Beneficiary beneficiary) {
        beneficiaryRepository.save(beneficiary);
    }

    @Override
    public void deleteBeneficiary(Beneficiary beneficiary) {
            beneficiaryRepository.delete(beneficiary);
    }

    @Override
    public Beneficiary getBeneficiaryById(int id) {
        return beneficiaryRepository.findById(id).get();
    }

    @Override
    public List<Beneficiary> getBeneficiaries() {
        return (List<Beneficiary>) beneficiaryRepository.findAll();
    }
}
