package com.adrian.eady.user;

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
    private String      name;
    private String      email;
    private String      passwordHash;
    private String      role;
    private Boolean     active;


    public User() {}

    public Long  getId() {
        return id;
    }

    public String getName(){
        return name;
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

    public void setName(String newName) {
        this.name = newName;
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
