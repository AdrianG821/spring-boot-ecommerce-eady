package com.adrian.eady.user;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.adrian.eady.user.dto.PasswordHashing;
import com.adrian.eady.user.dto.UserAuthDTO;
import com.adrian.eady.user.dto.UserCreateDTO;
import com.adrian.eady.user.dto.UserResponseDTO;
import com.adrian.eady.user.dto.UserUpdateDTO;

@Service
public class UserService {
    private final UserRepository db;
    private final PasswordEncoder passwordEncoder;


    public UserService( UserRepository db, PasswordEncoder passwordEncoder ) { this.db = db; this.passwordEncoder = passwordEncoder;}


    public List<UserResponseDTO> getAllUsers() {
        
        List<User> users = db.findAll();

        List<UserResponseDTO> response = users.stream().map( user -> new UserResponseDTO(user.getId(),user.getUsername(), user.getRole()) ).toList();

        return response;
    }

    public String createNewUser( UserCreateDTO user ) {
        String passwordHash     =    passwordEncoder.encode(user.getPassword());

        User exists             =    db.findByUsernameOrEmail(user.getUsername(), user.getEmail());

        if(exists != null) {
            return "exists";
        }

        User newUser            =    new User(user.getUsername(), user.getEmail(), passwordHash, "CUSTOMER");

        db.save(newUser);
        return "ok";
    }

    public UserResponseDTO authMethod(UserAuthDTO user) {
        if(user.getUsername() == null || user.getPassword() == null){
            return null;
        }

        User exists = db.findByUsername(user.getUsername());

        if(exists == null) {
            return null;
        }

        Boolean match = passwordEncoder.matches(user.getPassword(), exists.getPasswordHash());

        if(match){
            return new UserResponseDTO(exists.getId(),exists.getUsername(),exists.getRole());
        } else {
            return null;
        }
        
    }

    public UserResponseDTO patchUser(UserUpdateDTO dto) {
        if(dto.getId() == null || dto.getId() == 0) return null;

        User exists = db.findById(dto.getId()).orElse(null);

        if(exists == null) return null;

        if(dto.getEmail() != null) {
            exists.setEmail(dto.getEmail());
        }

        if(dto.getPassword() != null) {
            String newPass = passwordEncoder.encode(dto.getPassword());
            exists.setPasswordHash(newPass);
        }
        db.save(exists);

        return new UserResponseDTO(exists.getId(), exists.getUsername(), exists.getRole());


    }


    public Boolean activateUser(Long id) {
        if(id == null || id == 0){
            return false;
        }

        User user = db.findById(id).orElse(null);
        
        if(user == null) return false;

        Boolean isActive = user.getActive();

        if(isActive == true) {
            user.setActive(false);
        } else {
            user.setActive(true);
        }
        db.save(user);

        return true;
    }
}
