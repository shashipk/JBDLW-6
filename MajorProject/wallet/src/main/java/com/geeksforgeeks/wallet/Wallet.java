package com.geeksforgeeks.wallet;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double balance;
    @Column(nullable = false)
    private String currency;
    @Column(nullable = false)
    private String userid;
    private Date upadate_at=new Date();

    public Wallet(Double balance, String currency, String userid, Date upadate_at) {
        this.balance = balance;
        this.currency = currency;
        this.userid = userid;
        this.upadate_at = upadate_at;
    }

    public Wallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getUpadate_at() {
        return upadate_at;
    }

    public void setUpadate_at(Date upadate_at) {
        this.upadate_at = upadate_at;
    }
}
