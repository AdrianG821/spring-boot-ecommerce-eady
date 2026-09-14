package com.adrian.eady.user.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserCreateDTO {
    
    @Size(min = 4, max = 25)
    @NotBlank
    private String      username;

    @Size(min = 4, max = 40)
    @NotBlank   
    @Email
    private String      email;

    @Size(min = 4, max = 35)
    @NotBlank
    private String      password;



    public UserCreateDTO() {}



    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }


    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }


}
