package com.example.noddy.notification_system.filters;

import com.example.noddy.notification_system.service.jwtService.JwtServiceImplementation;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// custom filter for jwt authentication and authorization

/**
 * executes on every request
 * acts as a security gatekeeper for all the API's
 * the filter - intercepts request -> extracts jwt -> validates jwt -> extract roles / permissions -> creates authenticated user context -> tells spring user is authenticated
 *
 * needed because => every API request must verify is the user authenticated without asking user to login again
 */
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtServiceImplementation jwtServiceImplementation;

    @Autowired
    public JwtAuthFilter(JwtServiceImplementation jwtServiceImplementation){
        this.jwtServiceImplementation = jwtServiceImplementation;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{

            // extracting the header from the auth request
            final String authHeader = request.getHeader("Authorization");

            String jwtToken = null;
            String userName = null;

            // Check if header exists and starts with Bearer
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                filterChain.doFilter(request, response);
                return;
            }

            // Extract JWT Token
            jwtToken = authHeader.substring(7);
            // Extract Username
            userName = jwtServiceImplementation.extractUsername(jwtToken);

            // Proceed only if user not already authenticated
            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // Validate Token
                if (jwtServiceImplementation.isTokenValid(jwtToken)) {
                    List<String> roles = jwtServiceImplementation.extractRoles(jwtToken);   // Extract Roles
                    List<String> permissions = jwtServiceImplementation.extractPermissions(jwtToken);  // Extract Permissions

                    List<SimpleGrantedAuthority> authorities = new ArrayList<>();   // Convert to Spring Authorities

                    // Add Roles
                    if (roles != null) {
                        authorities.addAll(roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).toList());
                    }

                    // Add Permissions
                    if (permissions != null) {
                        authorities.addAll(permissions.stream().map(SimpleGrantedAuthority::new).toList());
                    }

                    // Create Authentication Token
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userName, null, authorities);

                    // Attach Request Details
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    // Set Authentication Context
                    SecurityContextHolder.getContext().setAuthentication(authToken);  // telling the current request is authenticated, else every API becomes unauthorized
                }
            }
        } catch (Exception e) {
            System.out.println("JWT Authentication Error: " + e.getMessage());
        }
        // Continue filter chain
        filterChain.doFilter(request, response);
    }
}
