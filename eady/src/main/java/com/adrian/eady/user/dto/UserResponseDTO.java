package com.adrian.eady.user.dto;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class UserResponseDTO {
    private Long        id;
    private String      username;
    private String      role;


    public UserResponseDTO() {}

    public UserResponseDTO(Long id,String username, String role) {
        this.id                =    id;
        this.username          =    username;
        this.role              =    role;
    }


    public Long  getId() {
        return id;
    }

    public String getUsername(){
        return username;
    }


    public String getRole(){
        return role;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public void setRole(String newRole) {
        this.role = newRole;
    }

}
