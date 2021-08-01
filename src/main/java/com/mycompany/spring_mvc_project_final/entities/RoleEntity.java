/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.entities;

import com.mycompany.spring_mvc_project_final.enums.Role;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author vanhuy
 */
@Entity
@Table(name = "role")
public class RoleEntity implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     
     @Column(length = 25)
     private Role role;
     
     @Column(length = 25)
     private String status;
             
     @ManyToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     private List<AccountEntity> account;

    public RoleEntity() {
    }

    public RoleEntity(int id, Role role, String status, List<AccountEntity> account) {
        this.id = id;
        this.role = role;
        this.status = status;
        this.account = account;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<AccountEntity> getAccount() {
        return account;
    }

    public void setAccount(List<AccountEntity> account) {
        this.account = account;
    }
     
     
}
