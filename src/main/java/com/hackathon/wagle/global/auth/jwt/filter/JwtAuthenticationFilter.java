package com.hackathon.wagle.global.auth.jwt.filter;

import com.hackathon.wagle.global.auth.jwt.user.JwtUserDetails;
import com.hackathon.wagle.global.auth.jwt.utils.JwtExtractor;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

import static com.hackathon.wagle.global.auth.jwt.exception.ErrorMessage.*;


@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtExtractor jwtExtractor;

    public static final String JWT_ERROR = "jwtError";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Optional<String> token = jwtExtractor.extractJwtToken(request);

        if (token.isEmpty()) {
            request.setAttribute(JWT_ERROR, ACCESS_TOKEN_NOT_FOUND);
            filterChain.doFilter(request, response);
            return;
        }

        String accessToken = token.get();
        if(!jwtExtractor.validateJwtToken(accessToken)) {
            request.setAttribute(JWT_ERROR, JWT_TOKEN_INVALID);
            filterChain.doFilter(request, response);
            return;
        }

        if(jwtExtractor.isExpired(accessToken)) {
            request.setAttribute(JWT_ERROR, ACCESS_TOKEN_EXPIRED);
            filterChain.doFilter(request, response);
            return;
        }

        saveAuthentication(accessToken);
        filterChain.doFilter(request, response);
    }

    private void saveAuthentication(String accessToken) {
        Long id = jwtExtractor.getId(accessToken);
        String email = jwtExtractor.getEmail(accessToken);
        String role = jwtExtractor.getRole(accessToken);

        UserDetails userDetails = JwtUserDetails.of(id, email, role);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
