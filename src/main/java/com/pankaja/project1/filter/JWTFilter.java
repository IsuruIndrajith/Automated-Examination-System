package com.pankaja.project1.filter;

import com.pankaja.project1.service.JWTtokenGenarator;
import com.pankaja.project1.service.MYUserDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JWTFilter extends OncePerRequestFilter {
    @Autowired
    JWTtokenGenarator jwtservice;

    @Autowired
    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeder = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (authHeder != null && authHeder.startsWith("Bearer ")){

            token = authHeder.substring(7);
            username = jwtservice.extractUserName(token);

        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication()==null){

            UserDetails userDetails = context.getBean(MYUserDetailService.class).loadUserByUsername(username);

           if(jwtservice.validateToken(token, userDetails) ){

               UsernamePasswordAuthenticationToken authToken = new
                       UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
           }

        }
        filterChain.doFilter(request,response);

    }
}
