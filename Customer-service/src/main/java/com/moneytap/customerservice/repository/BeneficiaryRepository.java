package com.moneytap.customerservice.repository;


import com.moneytap.customerservice.model.Beneficiary;
import org.springframework.data.repository.CrudRepository;

public interface BeneficiaryRepository extends CrudRepository<Beneficiary,Integer> {
}
