package com.example.model;

import lombok.Builder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * --- User Model for login system ---
 * <p>
 * H2:
 *
 * @Entity - Spring Boot and H2 will crate a table with the given variables.
 * @Id - Necessary for H2 database table (every entry has its own ID)
 * @GeneratedValue - ID will be generated automatically
 * validation:
 * @NotNull - May not be null
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 5, max = 25)
    @Column(unique = true)
    private String username;

    @Size(min = 5, max = 60)
    private String password;

    @NotNull
    private boolean enabled;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    private String email="";

    @Size(max = 30000)
    private String description="";
    @Size(max = 30000)
    private String pic="";

    @Builder
    public User(Long id, String username, String password, boolean enabled, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User(@Size(min = 5, max = 25) String username, @Size(min = 5, max = 60) String password, @NotNull boolean enabled, @NotNull Role role) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", role=" + role +
                '}';
    }
}