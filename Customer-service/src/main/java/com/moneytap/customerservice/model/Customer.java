package com.moneytap.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int customerId;

    private String name;
    private String mobileNumber;
    private String password;

    @OneToOne(cascade = CascadeType.MERGE)
    private Wallet wallet;

    public Customer(String name, String mobileNumber, String password) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    public Customer(String name, String mobileNumber, String password, Wallet wallet) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.wallet = wallet;
    }


    //  @OneToMany
    // private List<Beneficiary> beneficiaryList;

}
