package com.moneytap.customerservice.service;

import com.moneytap.customerservice.exception.UserNotFoundException;
import com.moneytap.customerservice.model.JwtResponse;

public interface JwtResponseService {

    void addToken(JwtResponse token);
    void deleteToken(JwtResponse  token);
    boolean checkTokenExists(String token) throws UserNotFoundException;
}
