/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.entities;

import com.mycompany.spring_mvc_project_final.enums.Gender;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author vanhuy
 */
@Entity
@Table(name = "guest")
public class GuestEntity extends PersonEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idCard;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingEntity booking;

    public GuestEntity() {
        super();
    }

 

    public GuestEntity(int id, int idCard, BookingEntity booking, String email, String fullName, Gender gender, String address, String phone, LocalDate birthDay) {
        super(email, fullName, gender, address, phone, birthDay);
        this.id = id;
        this.idCard = idCard;
        this.booking = booking;
    }

  



 



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }



    public BookingEntity getBooking() {
        return booking;
    }

    public void setBooking(BookingEntity booking) {
        this.booking = booking;
    }

   

   
   
}
