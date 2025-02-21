package com.hackathon.wagle.global.auth.jwt.user;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;
import java.util.List;

@Getter
public class JwtUserDetails extends User {

    private final Long id;
    private final String role;

    public JwtUserDetails(Long id, String email, List<GrantedAuthority> authorities, String role) {
        super(email, "", authorities);
        this.id = id;
        this.role = role;
    }

    public static JwtUserDetails of(Long id, String email, String role) {
        return new JwtUserDetails(id, email, Collections.singletonList(new SimpleGrantedAuthority(role)), role);
    }
}
