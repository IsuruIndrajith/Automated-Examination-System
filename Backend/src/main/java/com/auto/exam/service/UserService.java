package com.auto.exam.service;


import com.auto.exam.Dto.Login;
import com.auto.exam.Model.Role;
import com.auto.exam.Model.User;
import com.auto.exam.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private userRepo repo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }

    public Login verify(User user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            System.out.println("varify================================================");
            String role=authentication.getAuthorities().toString();
            String toc= jwtService.generateToken(user.getUsername());
            return new Login(toc,role);

        } else {
            System.out.println("fail================================================");
            return new Login(); 
        }
    }
}
