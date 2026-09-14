package com.adrian.eady.user.dto;

import jakarta.validation.constraints.NotBlank;

public class UserAuthDTO {
    @NotBlank
    private String      username;

    @NotBlank
    private String      password;



    public UserAuthDTO() {}



    public String getUsername(){
        return username;
    }


    public String getPassword(){
        return password;
    }



    public void setUsername(String newUsername) {
        this.username = newUsername;
    }


    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

}
