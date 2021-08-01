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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author vanhuy
 */
@Entity
@Table(name = "service")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 100)
    private String name;
    
    @Column(length = 1000)
    private String description;
    
    @Column(length = 20)
    private String phoneNumber;
    
    @Column(length = 25)
    private String status;
    
    private double price;
    
    @Column(length = 20)
    private String openTime;
    
    
    @Column(length = 100)
    private String location;
    
    
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    
    @OneToMany(mappedBy = "service")
    private List<ServiceBookingEntity> serviceBooking;
    
    @OneToMany(mappedBy = "service")
    private List<ImageEntity> images;

    public ServiceEntity() {
    }

    public ServiceEntity(int id, String name, String description, String phoneNumber, String status, double price, String openTime, String location, Date createDate, List<ServiceBookingEntity> serviceBooking, List<ImageEntity> images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.price = price;
        this.openTime = openTime;
        this.location = location;
        this.createDate = createDate;
        this.serviceBooking = serviceBooking;
        this.images = images;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<ServiceBookingEntity> getServiceBooking() {
        return serviceBooking;
    }

    public void setServiceBooking(List<ServiceBookingEntity> serviceBooking) {
        this.serviceBooking = serviceBooking;
    }

    public List<ImageEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }
    
}
