package com.Project2.BackEnd.Config;

import com.Project2.BackEnd.Repo.UserRepository;
import com.Project2.BackEnd.Services.JwtService;

import com.Project2.BackEnd.Entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired private JwtService jwtService;
    @Autowired private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("✅ JwtAuthenticationFilter called");

        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String nic;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("⛔ No valid Authorization header found!");
            filterChain.doFilter(request, response);
            return;
        }

        jwt = authHeader.substring(7);
        nic = jwtService.extractUsername(jwt);

        System.out.println("JWT = " + jwt);
        System.out.println("NIC from token = " + nic);

        if (nic != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            User user = userRepository.findByNic(nic).orElse(null);
            if (user != null && jwtService.isTokenValid(jwt, nic)) {
                System.out.println("✅ Token is valid for user: " + nic);

                UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                        user.getNic(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
                );

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                System.out.println("⛔ Token invalid or user not found.");
            }
        }

        filterChain.doFilter(request, response);
    }
}

