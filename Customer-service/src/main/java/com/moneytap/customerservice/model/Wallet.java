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
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
 //   @Column(name = "wallet_id")
    private int walletId;
 //   @Column(name = "wallet_balance")
    private int walletBalance;

    public Wallet(int walletBalance) {
        this.walletBalance = walletBalance;
    }
    /*
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    public Wallet(Customer customer) {
        this.customer = customer;
    }

     */

    /*
    @OneToMany
  //  @OneToOne
    //@ManyToOne
    private List<BankAccount> bankAccountList;

    @OneToMany
    private List<Transaction> transactionList;

    @OneToMany
    private List<BillPayment> billPaymentList;

    @OneToMany
    private List<Beneficiary> beneficiaryList;


    public Wallet(int walletId, int walletBalance) {
        this.walletId = walletId;
        this.walletBalance = walletBalance;
    }

 */
}
