package com.example.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public enum Role {

    ADMIN,
    USER;

    /**
     * converts a role into a GrantedAuthority
     * @return Prefix ROLE_ + the role
     */

    public GrantedAuthority toAuthority() {
        return new SimpleGrantedAuthority("ROLE_" + this.toString());
    }

    /**
     * converts a list of roles into GrantedAuthority
     */

    public GrantedAuthority toAuthority(List<Role> roles) {
        List<String> grantedAuthorites = new ArrayList<>();
        for(Role role: roles) {
            grantedAuthorites.add("ROLE_" + role);
        }
        return new SimpleGrantedAuthority(grantedAuthorites.toString());
    }
}