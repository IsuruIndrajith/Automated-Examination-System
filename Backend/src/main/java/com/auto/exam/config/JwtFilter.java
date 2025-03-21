package com.auto.exam.config;

import com.auto.exam.service.JWTService;
import com.auto.exam.service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;

    @Autowired
    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//  Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraWxsIiwiaWF0IjoxNzIzMTgzNzExLCJleHAiOjE3MjMxODM4MTl9.5nf7dRzKRiuGurN2B9dHh_M5xiu73ZzWPr6rbhOTTHs
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            System.out.println("auth1=====================");
            token = authHeader.substring(7);
            username = jwtService.extractUserName(token);
            System.out.println(token+"====================="+username+"=====");
        }else {
            System.out.println("else1============================");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            System.out.println("auth2=============================");
            UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(username);
            System.out.println("auth3=============================");

            if (jwtService.validateToken(token, userDetails)) {
                System.out.println("auth4======================================================");
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                System.out.println("auth5===================================================");
                authToken.setDetails(new WebAuthenticationDetailsSource()
                        .buildDetails(request));
                System.out.println("auth6================================================");
                SecurityContextHolder.getContext().setAuthentication(authToken);

                System.out.println("auth7===============================================");
            }else{
                System.out.println("else3=====================================");
            }
        }else{
            System.out.println("else===========================================");
        }
        System.out.println("===================="+request);
        filterChain.doFilter(request, response);
    }
}


