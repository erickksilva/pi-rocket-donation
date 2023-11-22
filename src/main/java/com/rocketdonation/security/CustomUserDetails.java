package com.rocketdonation.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private String email;
    private String password;
    private List<GrantedAuthority> authorities;

    public CustomUserDetails(String email, String password, List<String> roles) {
        this.email = email;
        this.password = password;
        this.authorities = roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("Authorities: " + authorities);
        return authorities;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    // Outros métodos da interface UserDetails (isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired, isEnabled)

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implemente a lógica adequada, se necessário
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implemente a lógica adequada, se necessário
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implemente a lógica adequada, se necessário
    }

    @Override
    public boolean isEnabled() {
        return true; // Implemente a lógica adequada, se necessário
    }
}
