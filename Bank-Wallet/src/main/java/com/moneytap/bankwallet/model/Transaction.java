package com.moneytap.bankwallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

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
    private LocalDate date=LocalDate.now();
    private int amount;
    private String status;
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Wallet wallet;

    public Transaction( int amount, String description) {

        this.amount = amount;
        this.description = description;
    }
}
