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
public class BillPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int billId;
    private String billType;
    private String billDate;
    private String status;
    private String description;
    private int amount;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Wallet wallet;
}
