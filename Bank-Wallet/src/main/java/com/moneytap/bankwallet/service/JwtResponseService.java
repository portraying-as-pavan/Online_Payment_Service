package com.moneytap.bankwallet.service;


import com.moneytap.bankwallet.exception.UserNotFoundException;
import com.moneytap.bankwallet.model.JwtResponse;

public interface JwtResponseService {

    void addToken(JwtResponse token);
    void deleteToken(JwtResponse  token);
    boolean checkTokenExists(String token) throws UserNotFoundException;
}
