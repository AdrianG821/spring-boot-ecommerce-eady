package com.adrian.eady.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserUpdateDTO {

    @Min(1) 
    @NotNull
    private Long        id;

    @Size(min = 4, max = 40)
    @Email   
    private String      email;

    @Size(min = 4, max = 35)
    private String      password;



    public UserUpdateDTO() {}


    public Long   getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }


    public void setId(Long id){
        this.id =  id;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

}
