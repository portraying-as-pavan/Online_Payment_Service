package com.moneytap.bankwallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
  //  @Column(name = "acc_no")
    private int accNo;
 //   @Column(name = "ifsc")
    private String IFSC;
//    @Column(name = "bank_name")
    private String bankName;
//    @Column(name = "bank_balance")
    private int bankBalance;

    @ManyToOne(cascade = CascadeType.ALL)
    private Wallet wallet;

    public BankAccount(String IFSC, String bankName) {
        this.IFSC = IFSC;
        this.bankName = bankName;
    }




}
