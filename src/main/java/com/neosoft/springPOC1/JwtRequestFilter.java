package com.neosoft.springPOC1;

import com.neosoft.springPOC1.service.UserServiceImpl;
import com.neosoft.springPOC1.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtToken jwtToken;
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public JwtRequestFilter(JwtToken jwtToken , UserServiceImpl userServiceImpl) {
        this.jwtToken = jwtToken;
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String emailId = null;
        String jwtTokenStr = null;

        String authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")){
            jwtTokenStr = authorizationHeader.substring(7);
            emailId = jwtToken.extractUserName(jwtTokenStr);
        }

        if(emailId!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = userServiceImpl.loadUserByUsername(emailId);
            if(jwtToken.validateToken(jwtTokenStr , userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails,null , userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        filterChain.doFilter(request , response);
    }
}
