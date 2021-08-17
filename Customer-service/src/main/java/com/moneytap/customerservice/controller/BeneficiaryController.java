package com.moneytap.customerservice.controller;


import com.moneytap.customerservice.exception.UserNotFoundException;
import com.moneytap.customerservice.model.Beneficiary;
import com.moneytap.customerservice.service.BeneficiaryService;
import com.moneytap.customerservice.service.JwtResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/beneficiary")
public class BeneficiaryController {
    @Autowired
    private BeneficiaryService beneficiaryService;
    @Autowired
    private JwtResponseService jwtResponseService;

    @PostMapping(value = "/add")
    public void addBeneficiary(@RequestBody Beneficiary beneficiary,@RequestHeader("Authorization") String token) throws UserNotFoundException {
        if(jwtResponseService.checkTokenExists(token)) {
            beneficiaryService.addBeneficiary(beneficiary);
        }else {
            throw new UserNotFoundException("Please Login!");
        }
    }

    @RequestMapping(value = "/show/{beneficiaryId}")
    public Beneficiary getBeneficiaryById(@PathVariable int beneficiaryId,@RequestHeader("Authorization") String token){
        try{
            jwtResponseService.checkTokenExists(token);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return beneficiaryService.getBeneficiaryById(beneficiaryId);
    }

    @GetMapping(value = "/delete")
    public void deleteBeneficiary(@RequestBody Beneficiary beneficiary,@RequestHeader("Authorization") String token){
        try{
            jwtResponseService.checkTokenExists(token);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        beneficiaryService.deleteBeneficiary(beneficiary);
    }
}
