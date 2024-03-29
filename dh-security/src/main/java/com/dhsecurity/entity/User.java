package com.dhsecurity.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="app_user")
public class User {
    @Id @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @Column(name="username")
    private String username;
    
    @Column(name="password")
    private String password;
    
    @OneToMany
    @JoinColumn(name="APP_USER_ID", referencedColumnName="ID")
    private List<UserRole> roles;
    
    public User() { }
    
    public User(Long id, String username, String password, List<UserRole> roles) {
        this.Id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return Id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<UserRole> getRoles() {
        return roles;
    }
}
