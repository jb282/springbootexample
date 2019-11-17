package com.example.config;


import com.example.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

/**
 * implementation for UserDetails used by Spring Security for Authentication and Authorization
 */

public class SpringSecurityUser implements UserDetails {

    @Getter
    private final User user;
    private final String username;

    @Getter
    private final Collection<? extends GrantedAuthority> authorities;


    public SpringSecurityUser(User user, final String username) {
        this.user = user;
        this.username = username;
        this.authorities = Optional.ofNullable(user.getRole()).map(role -> new SimpleGrantedAuthority("ROLE_" + role.name())).map(Collections::singleton).orElse(new HashSet<>());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return username;
    }
}