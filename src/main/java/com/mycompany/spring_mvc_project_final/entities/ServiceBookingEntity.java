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
@Table(name = "service_booking")
public class ServiceBookingEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
   
//    @Temporal(TemporalType.DATE)
    @Column(name = "service_booking_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate serviceBookDate;
    
    private int quantity;
    
    
    private double price;
    
    @ManyToOne
    @JoinColumn(name = "bookingDetail_id")
    private BookingDetailEntity bookingDetail;
    
    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceEntity service;

    public ServiceBookingEntity() {
    }

    public ServiceBookingEntity(int id, LocalDate serviceBookDate, int quantity, double price, BookingDetailEntity bookingDetail, ServiceEntity service) {
        this.id = id;
        this.serviceBookDate = serviceBookDate;
        this.quantity = quantity;
        this.price = price;
        this.bookingDetail = bookingDetail;
        this.service = service;
    }

    

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getServiceBookDate() {
        return serviceBookDate;
    }

    public void setServiceBookDate(LocalDate serviceBookDate) {
        this.serviceBookDate = serviceBookDate;
    }

 

 
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookingDetailEntity getBookingDetail() {
        return bookingDetail;
    }

    public void setBookingDetail(BookingDetailEntity bookingDetail) {
        this.bookingDetail = bookingDetail;
    }

    public ServiceEntity getService() {
        return service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }
    
    
}
