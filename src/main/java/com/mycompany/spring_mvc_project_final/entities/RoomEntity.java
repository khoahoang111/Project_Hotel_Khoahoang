/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.entities;

import com.mycompany.spring_mvc_project_final.enums.RoomEnum;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
    @Column(length = 25)
    private String roomNumber;
    
    @Column(length = 25)
    private RoomEnum roomEnum;
    
    
    private double price;
    
    
    private int numberOfBed;
    
    
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    
    @OneToMany(mappedBy = "room")
    private List<BookingDetailEntity> bookingDetail;
    
    @ManyToOne
    @JoinColumn(name = "roomtype_id")
    private RoomTypeEntity roomType;

    public RoomEntity() {
    }

    public RoomEntity(int id, String roomNumber, RoomEnum roomEnum, double price, int numberOfBed, Date createDate, List<BookingDetailEntity> bookingDetail, RoomTypeEntity roomType) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomEnum = roomEnum;
        this.price = price;
        this.numberOfBed = numberOfBed;
        this.createDate = createDate;
        this.bookingDetail = bookingDetail;
        this.roomType = roomType;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomEnum getRoomEnum() {
        return roomEnum;
    }

    public void setRoomEnum(RoomEnum roomEnum) {
        this.roomEnum = roomEnum;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfBed() {
        return numberOfBed;
    }

    public void setNumberOfBed(int numberOfBed) {
        this.numberOfBed = numberOfBed;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<BookingDetailEntity> getBookingDetail() {
        return bookingDetail;
    }

    public void setBookingDetail(List<BookingDetailEntity> bookingDetail) {
        this.bookingDetail = bookingDetail;
    }

    public RoomTypeEntity getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeEntity roomType) {
        this.roomType = roomType;
    }
    
    
}
