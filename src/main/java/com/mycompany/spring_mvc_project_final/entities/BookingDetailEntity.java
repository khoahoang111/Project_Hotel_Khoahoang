/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author vanhuy
 */
@Entity
@Table(name = "booking_detail")
public class BookingDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
   
    private double price;
    private double discount;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingEntity booking;

    @ManyToOne
    @JoinColumn(name = "rooom_id")
    private RoomEntity room;

    @OneToMany(mappedBy = "bookingDetail")
    private List<ServiceBookingEntity> serviceBooking;

    public BookingDetailEntity() {
    }

    public BookingDetailEntity(int id, double price, double discount, BookingEntity booking, RoomEntity room, List<ServiceBookingEntity> serviceBooking) {
        this.id = id;
        this.price = price;
        this.discount = discount;
        this.booking = booking;
        this.room = room;
        this.serviceBooking = serviceBooking;
    }

    

  
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }



    public BookingEntity getBooking() {
        return booking;
    }

    public void setBooking(BookingEntity booking) {
        this.booking = booking;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    public List<ServiceBookingEntity> getServiceBooking() {
        return serviceBooking;
    }

    public void setServiceBooking(List<ServiceBookingEntity> serviceBooking) {
        this.serviceBooking = serviceBooking;
    }

}
