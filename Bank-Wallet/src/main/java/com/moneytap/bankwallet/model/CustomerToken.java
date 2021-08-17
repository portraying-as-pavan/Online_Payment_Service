package com.moneytap.bankwallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerToken {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  String token;
    private String mobileNumber;

}
