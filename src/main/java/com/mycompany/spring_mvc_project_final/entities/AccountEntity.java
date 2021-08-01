/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.entities;

import com.mycompany.spring_mvc_project_final.enums.Gender;
import com.mycompany.spring_mvc_project_final.enums.UserStatus;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
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
@Table(name = "account")
public class AccountEntity extends PersonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 100)
    private String passsword;
    
    @Column(length = 25)
    private UserStatus userStatus;
    
    @Column(length = 2)
    private int vote;
    
    
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @OneToMany(mappedBy = "account")
    private List<BookingEntity> booking;

    @OneToMany(mappedBy = "accountComment")
    private List<CommentEntity> comment;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "account_role",
            joinColumns =  @JoinColumn(name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private List<RoleEntity> role;
    
    
    
    
//        @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(name = "user_role_relationship",
//            joinColumns = @JoinColumn(name = "user_id",
//                    referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "role_id",
//                    referencedColumnName = "id"))
//    private Set<UserRoleEntity> userRoles;
    
    

    public AccountEntity() {
    }

 

    public AccountEntity(int id, String passsword, UserStatus userStatus, int vote, Date createDate, List<BookingEntity> booking, List<CommentEntity> comment, List<RoleEntity> role, String email, String fullName, Gender gender, String address, String phone, LocalDate birthDay) {
        super(email, fullName, gender, address, phone, birthDay);
        this.id = id;
        this.passsword = passsword;
        this.userStatus = userStatus;
        this.vote = vote;
        this.createDate = createDate;
        this.booking = booking;
        this.comment = comment;
        this.role = role;
    }

  




   

  


   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }



    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }



    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<BookingEntity> getBooking() {
        return booking;
    }

    public void setBooking(List<BookingEntity> booking) {
        this.booking = booking;
    }

    public List<CommentEntity> getComment() {
        return comment;
    }

    public void setComment(List<CommentEntity> comment) {
        this.comment = comment;
    }

    public List<RoleEntity> getRole() {
        return role;
    }

    public void setRole(List<RoleEntity> role) {
        this.role = role;
    }


}
