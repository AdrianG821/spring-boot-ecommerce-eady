package com.adrian.eady.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adrian.eady.user.User;
import com.adrian.eady.user.UserRepository;



@Service 
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {


        // aici vei căuta userul tău în DB
        User user = userRepository.findByUsername(username);

        if(user == null) throw new UsernameNotFoundException("Username not found!");

        // aici îl vei transforma în UserDetails
        
        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(user.getPasswordHash()).roles(user.getRole()).disabled(!user.getActive()).build();

    }
}
