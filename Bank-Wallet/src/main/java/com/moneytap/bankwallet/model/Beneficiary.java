package com.moneytap.bankwallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int beneficiaryId;

    private String name;
    private String mobileNumber;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Wallet wallet;




}
