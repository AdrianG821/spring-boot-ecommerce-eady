package com.adrian.eady.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.eady.user.dto.UserAuthDTO;
import com.adrian.eady.user.dto.UserCreateDTO;
import com.adrian.eady.user.dto.UserResponseDTO;
import com.adrian.eady.user.dto.UserUpdateDTO;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private final UserService service;

    public UserController(UserService service) { this.service = service; }

    @GetMapping("/get/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = service.getAllUsers();

        return ResponseEntity.ok(users);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createNewUser(@Valid @RequestBody UserCreateDTO dto) {
        //TODO: process POST request

        User response = service.createNewUser(dto);

        if(response != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/auth")
    public ResponseEntity<UserResponseDTO> authMethod(@Valid @RequestBody UserAuthDTO dto) {
        //TODO: process POST request+

        UserResponseDTO response = service.authMethod(dto);

        if(response != null) {
            ResponseEntity.ok(response);
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
        
    }

    @PatchMapping("/update")
    public ResponseEntity<UserResponseDTO> patchUser(@Valid @RequestBody UserUpdateDTO dto) {

        UserResponseDTO response = service.patchUser(dto);

        if(response != null) {
            ResponseEntity.ok(response);
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }


    }

    @PostMapping("/activate/{id}")
    public ResponseEntity<Boolean> activateUser(@PathVariable("id") int id) {
        //TODO: process POST request

        Boolean response = service.activateUser(id);
        
        if(response == true) {
            ResponseEntity.status(HttpStatus.OK).build();
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    

}
