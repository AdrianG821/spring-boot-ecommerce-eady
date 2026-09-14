package com.adrian.eady.user;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long        id;
    private String      username;
    private String      email;
    private String      passwordHash;
    private String      role;
    private Boolean     active;
    
    @CreationTimestamp
    private Date        createdAt;


    public User() {}

    public User(String username, String email, String passwordHash, String role) {
        this.username          =    username;
        this.email             =    email;
        this.passwordHash      =    passwordHash;
        this.role              =    role;
        this.active            =    true;

    }


    public Long  getId() {
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPasswordHash(){
        return passwordHash;
    }

    public String getRole(){
        return role;
    }

    public Boolean getActive(){
        return active;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setPasswordHash(String newPasswordHash) {
        this.passwordHash = newPasswordHash;
    }

    public void setRole(String newRole) {
        this.role = newRole;
    }

    public void setActive(Boolean newActive) {
        this.active = newActive;
    }
}
