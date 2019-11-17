package com.example.config;

import com.example.model.User;
import com.example.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * retrieves UserDetails(SpringSecurityUser) directly from userRepo
 */

@Service("userDetailsService")
@Transactional
public class SystemUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final User user = userRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        } else {
            return new SpringSecurityUser(user, username);
        }
    }
}