package com.pankaja.project1.service;

import com.pankaja.project1.model.User;
import com.pankaja.project1.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSerivice {
    @Autowired
    UserRepo repo;

    @Autowired
    AuthenticationManager authmanager;

    @Autowired
    JWTtokenGenarator jwtservice;

    private BCryptPasswordEncoder ecoder = new BCryptPasswordEncoder(12);
    public User RegisterUser(User user) {
        user.setPassword(ecoder.encode(user.getPassword()));
        return  repo.save(user);
    }

    public String VeryfyUser(User user) {
        Authentication authentication = authmanager.
                authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));

        if(authentication.isAuthenticated())
            return jwtservice.genarateToken(user.getUserName());


        return "Fail";
    }
}
