package com.example.noddy.notification_system.service.rbacService;

import com.example.noddy.notification_system.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// generating a custom class for spring security authentication to load the user for the user details
// bridge between Spring Security and your database

/**
 * HOW to fetch users from database
 * spring security does not know table names, structures, repositories and DB Schemas
 * so this acts as a bridge between Spring Security and your database
 */

@Service
public class CustomUserDetailsServiceImplementation implements UserDetailsService {

    private final UserDataRepository userDataRepository;

    @Autowired
    public CustomUserDetailsServiceImplementation(UserDataRepository userDataRepository){
        this.userDataRepository = userDataRepository;
    }

    /**
     * spring automatically calls this during login authentication, JWT validation, security context rebuilding
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDataRepository.findByUsername(username).orElseThrow();
    }
}
