/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.entities;

import com.mycompany.spring_mvc_project_final.enums.Gender;
import com.mycompany.spring_mvc_project_final.enums.bookingstatus;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author vanhuy
 */
@Entity
@Table(name = "booking")
public class BookingEntity extends PersonEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
    @Temporal(TemporalType.DATE)
    @Column(name = "booking_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bookingDate;
    
    
   
    @Column(name = "checkin_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkIn;
    
    
  
    @Column(name = "checkout_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkOut;
    
   @Enumerated(EnumType.STRING)
    private bookingstatus bookingstatus;
    private double totalPrice;

    @OneToMany(mappedBy = "booking")
    private List<GuestEntity> guest;

    @OneToMany(mappedBy = "booking")
    private List<paymentEntity> payment;

    @OneToMany(mappedBy = "booking")
    private List<BookingDetailEntity> bookingDetail;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    public BookingEntity() {
    }


    public BookingEntity(int id, Date bookingDate, LocalDate checkIn, LocalDate checkOut, bookingstatus bookingstatus, double totalPrice, List<GuestEntity> guest, List<paymentEntity> payment, List<BookingDetailEntity> bookingDetail, AccountEntity account, String email, String fullName, Gender gender, String address, String phone, LocalDate birthDay) {
        super(email, fullName, gender, address, phone, birthDay);
        this.id = id;
        this.bookingDate = bookingDate;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookingstatus = bookingstatus;
        this.totalPrice = totalPrice;
        this.guest = guest;
        this.payment = payment;
        this.bookingDetail = bookingDetail;
        this.account = account;
    }







 




   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public bookingstatus getBookingstatus() {
        return bookingstatus;
    }

    public void setBookingstatus(bookingstatus bookingstatus) {
        this.bookingstatus = bookingstatus;
    }


 

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }



    public List<GuestEntity> getGuest() {
        return guest;
    }

    public void setGuest(List<GuestEntity> guest) {
        this.guest = guest;
    }

    public List<paymentEntity> getPayment() {
        return payment;
    }

    public void setPayment(List<paymentEntity> payment) {
        this.payment = payment;
    }

    public List<BookingDetailEntity> getBookingDetail() {
        return bookingDetail;
    }

    public void setBookingDetail(List<BookingDetailEntity> bookingDetail) {
        this.bookingDetail = bookingDetail;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

  

}
