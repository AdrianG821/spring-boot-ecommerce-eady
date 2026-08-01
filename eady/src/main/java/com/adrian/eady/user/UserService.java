package com.adrian.eady.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrian.eady.user.dto.UserAuthDTO;
import com.adrian.eady.user.dto.UserCreateDTO;
import com.adrian.eady.user.dto.UserResponseDTO;

@Service
public class UserService {
    private final UserRepository db;


    public UserService( UserRepository db ) { this.db = db; }


    public List<User> getAllUsers() {
        
        List<User> users = db.findAll();

        return users;
    }

    public User createNewUser( UserCreateDTO user ) {
        User newUser = db.save(user);
        return newUser;
    }

    public UserResponseDTO authMethod(UserAuthDTO user) {

        
    }





}
