package com.moneytap.bankwallet.service;


import com.moneytap.bankwallet.exception.UserNotFoundException;
import com.moneytap.bankwallet.model.JwtResponse;
import com.moneytap.bankwallet.repository.JwtResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class JwtResponseServiceImpl implements JwtResponseService{
    @Autowired
    private JwtResponseRepository jwtResponseRepository;

    @Override
    public void addToken(JwtResponse token) {
        jwtResponseRepository.save(token);
    }

    @Override
    public void deleteToken(JwtResponse token) {
            jwtResponseRepository.delete(token);
    }

    @Override
    public boolean checkTokenExists(String token) throws UserNotFoundException {
        boolean result=jwtResponseRepository.existsById(token);
        if(!result){
            throw new UserNotFoundException("Please Login!");
        }
        return result;
    }
}
