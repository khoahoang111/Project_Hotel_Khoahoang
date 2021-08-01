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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author vanhuy
 */
//@Entity
@MappedSuperclass
public abstract class PersonEntity implements Serializable {

    @Column(length = 100)
//    @NotNull(message = "Enter email not null!!!")
    private String email;

    @Column(length = 100)
    @NotNull(message = "Enter full name not null!!!")
    private String fullName;

@Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 100)
    @NotNull(message = "Enter Address not null!!!")
    private String address;

    @Column(length = 20)
//    @NotNull(message = "Enter phone not null!!!")
    private String phone;


    @NotNull(message = "This field is required")
    @Column(name = "birthday_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;

    public PersonEntity() {
    }

    public PersonEntity(String email, String fullName, Gender gender, String address, String phone, LocalDate birthDay) {
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.birthDay = birthDay;
    }

 
 

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

 

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }



    @Override
    public String toString() {
        return "PersonEntity{" + "email=" + email + ", fullName=" + fullName + ", gender=" + gender + ", address=" + address + ", phone=" + phone + ", birthDay=" + birthDay + '}';
    }

    
}
