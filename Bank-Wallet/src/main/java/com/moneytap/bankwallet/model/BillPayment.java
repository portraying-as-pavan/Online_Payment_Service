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
public class BillPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int billId;
    private String billType;
    private LocalDate billDate=LocalDate.now();
    private String status;
    private String description;
    private int amount;

    public BillPayment(String billType, String description, int amount) {
        this.billType = billType;
        this.description = description;
        this.amount = amount;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    private Wallet wallet;
}
