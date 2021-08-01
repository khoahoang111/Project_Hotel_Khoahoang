/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author vanhuy
 */
@Entity
@Table(name = "convenient")
public class ConvenientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 100)
    private String name;
    
    
    @Column(length = 1000)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "convenient_roomtype", joinColumns = {
        @JoinColumn(name = "convenient_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "roomtype_id")})
    private List<RoomTypeEntity> roomType;

    public ConvenientEntity() {
    }

    public ConvenientEntity(int id, String name, String description, List<RoomTypeEntity> roomType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.roomType = roomType;
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

    public List<RoomTypeEntity> getRoomType() {
        return roomType;
    }

    public void setRoomType(List<RoomTypeEntity> roomType) {
        this.roomType = roomType;
    }

}
