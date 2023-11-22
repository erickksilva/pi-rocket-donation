package com.rocketdonation.security;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWTFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String token = extractToken(request);

            if (token != null && !token.isEmpty()) {
                JWTObject tokenObject = JWTCreator.create(token, SecurityConfig.PREFIX, SecurityConfig.KEY);

                // Corrigir: Extrair o e-mail corretamente
                String email = tokenObject.getSubject();


                UsernamePasswordAuthenticationToken authenticationToken = getUsernamePasswordAuthenticationToken(email, tokenObject);

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                response.addHeader(HttpHeaders.AUTHORIZATION, token);

                System.out.println("E-mail do usuário autenticado: " + email);
                System.out.println("Roles do usuário autenticado: " + tokenObject.getRoles());

            } else {
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException e) {
            e.printStackTrace(); // Ajuste conforme necessário
            response.setStatus(HttpStatus.FORBIDDEN.value());
        }
    }

    private static UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String email, JWTObject tokenObject) {
        CustomUserDetails userDetails = new CustomUserDetails(
                email,
                "", // Você não está armazenando a senha no token, então deixe vazio por enquanto
                tokenObject.getRoles());

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());
        return authenticationToken;
    }

    private String extractToken(HttpServletRequest request) {
        String token = request.getHeader(JWTCreator.HEADER_AUTHORIZATION);
        if (StringUtils.hasText(token) && token.startsWith(SecurityConfig.PREFIX)) {
            return token.substring(SecurityConfig.PREFIX.length());
        }
        return null;
    }

    private List<SimpleGrantedAuthority> authorities(List<String> roles) {
        return roles.stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}