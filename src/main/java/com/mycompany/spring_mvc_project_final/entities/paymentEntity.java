/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.entities;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author vanhuy
 */
@Entity
@Table(name = "payment")
public class paymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
    private double amount;
    
    
 
    @Column(name = "payment_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;
    
    @Column(length = 1000)
    private String description;
    
    
  
    
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingEntity booking;
    
    @ManyToOne
    @JoinColumn(name = "creditCard_id")
    private CreditCardEntity creditCard;

    public paymentEntity() {
    }

    public paymentEntity(int id, double amount, LocalDate paymentDate, String description, BookingEntity booking, CreditCardEntity creditCard) {
        this.id = id;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.description = description;
        this.booking = booking;
        this.creditCard = creditCard;
    }

  
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

 

    public BookingEntity getBooking() {
        return booking;
    }

    public void setBooking(BookingEntity booking) {
        this.booking = booking;
    }

    public CreditCardEntity getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardEntity creditCard) {
        this.creditCard = creditCard;
    }
    
    
}
