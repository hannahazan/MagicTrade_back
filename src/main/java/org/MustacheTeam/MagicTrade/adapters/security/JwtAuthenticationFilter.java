package org.MustacheTeam.MagicTrade.adapters.security;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String jwt = null;
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);
            /*String jwt = authHeader.substring(7);
            Claims claims = jwtService.extractClaims(jwt);
            String username = claims.getSubject();
            Object uid = claims.get("uid");
            Long id = (uid instanceof Number n) ? n.longValue() : Long.parseLong(uid.toString());

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (jwtService.extractClaims(jwt).getExpiration().after(new Date())) {
                    CurrentTrader current = new CurrentTrader(id, username, null, userDetails.getAuthorities(), true);
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            current, null, current.getAuthorities()
                    );
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }*/
        }

        if (jwt == null && request.getCookies() != null) {
            for (var c : request.getCookies()) {
                if ("access_token".equals(c.getName())) {
                    jwt = c.getValue();
                    break;
                }
            }
        }

        if (jwt != null) {
            Claims claims = jwtService.extractClaims(jwt);
            String username = claims.getSubject();
            Object uid = claims.get("uid");
            Long id = (uid instanceof Number n) ? n.longValue() : Long.parseLong(uid.toString());

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (claims.getExpiration().after(new Date())) {
                    CurrentTrader current = new CurrentTrader(id, username, null, userDetails.getAuthorities(), true); // :contentReference[oaicite:6]{index=6}
                    var authentication = new UsernamePasswordAuthenticationToken(current, null, current.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}