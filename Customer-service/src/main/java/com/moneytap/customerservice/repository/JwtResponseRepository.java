package com.moneytap.customerservice.repository;

import com.moneytap.customerservice.model.JwtResponse;
import org.springframework.data.repository.CrudRepository;

public interface JwtResponseRepository extends CrudRepository<JwtResponse,String> {


}
