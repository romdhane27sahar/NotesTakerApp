package com.epi.notestakerapp2.config;

import com.epi.notestakerapp2.entity.User;
import com.epi.notestakerapp2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    /*
    CustomUserDetailsService implements UserDetailsService interface from Spring Security to be responsible
    for loading a UserDetails object based on a username provided during authentication.
    */

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        } else {
            return new CustomUser(user);//object that implements the UserDetails interface and provides the necessary user information for authentication.
        }

    }
}
