/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author vanhuy
 */
@Entity
@Table(name = "credit_card")
public class CreditCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String name;

    @Column(length = 20,unique = true)
    private String cardNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "exp_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expDate;

   @NotNull
    private String ccvCode;

    private double balance;

    @OneToMany(mappedBy = "creditCard")
    private List<paymentEntity> payment;

    public CreditCardEntity() {
    }

    public CreditCardEntity(int id, String name, String cardNumber, Date expDate, String ccvCode, double balance, List<paymentEntity> payment) {
        this.id = id;
        this.name = name;
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.ccvCode = ccvCode;
        this.balance = balance;
        this.payment = payment;
    }

    

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getCcvCode() {
        return ccvCode;
    }

    public void setCcvCode(String ccvCode) {
        this.ccvCode = ccvCode;
    }

  

   

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<paymentEntity> getPayment() {
        return payment;
    }

    public void setPayment(List<paymentEntity> payment) {
        this.payment = payment;
    }

}
