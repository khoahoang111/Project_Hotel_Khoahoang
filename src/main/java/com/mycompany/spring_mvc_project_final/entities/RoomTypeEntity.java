/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "room_type")
public class RoomTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 100)
    private String name;
    
    @Column(length = 25)
    private String status;
    
    @Column(length = 1000)
    private String description;
    
    @Column(length = 100)
    private String size;
    
    
    private int guest;
    
    
    @Temporal(TemporalType.DATE)
    @Column(name = "exp_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    
    @OneToMany(mappedBy = "roomType")
    private List<ImageEntity> images;
    
    @ManyToMany(mappedBy = "roomType",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ConvenientEntity> convenient;
    
    @ManyToMany(mappedBy = "roomType",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PromotionEntity> promotions;
    
    @OneToMany(mappedBy = "roomType")
    private List<RoomEntity> rooms;

    public RoomTypeEntity() {
    }

    public RoomTypeEntity(int id, String name, String status, String description, String size, int guest, Date createDate, List<ImageEntity> images, List<ConvenientEntity> convenient, List<PromotionEntity> promotions, List<RoomEntity> rooms) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.description = description;
        this.size = size;
        this.guest = guest;
        this.createDate = createDate;
        this.images = images;
        this.convenient = convenient;
        this.promotions = promotions;
        this.rooms = rooms;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getGuest() {
        return guest;
    }

    public void setGuest(int guest) {
        this.guest = guest;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<ImageEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }

    public List<ConvenientEntity> getConvenient() {
        return convenient;
    }

    public void setConvenient(List<ConvenientEntity> convenient) {
        this.convenient = convenient;
    }

    public List<PromotionEntity> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<PromotionEntity> promotions) {
        this.promotions = promotions;
    }

    public List<RoomEntity> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomEntity> rooms) {
        this.rooms = rooms;
    }
    
    
}
