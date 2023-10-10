package com.MovieFlix.MovieFlixWebsite.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class Users implements UserDetails {

    @PrePersist
    protected void onCreate() {
        this.created_At=new Date(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_At=new Date(System.currentTimeMillis());
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String username;
    private String password;
    private Date created_At;
    private Date updated_At;

    public Users(String user_name, String password){
        this.username = user_name;
        this.password = password;
    }
    @OneToMany(mappedBy = "users",cascade=CascadeType.ALL)
    private List<Comment> comment;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return true;
    }
}
