package com.moneytap.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int transactionId;
    private String transaction_type;
    private String date;
    private int amount;
    private String status;
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Wallet wallet;
}
