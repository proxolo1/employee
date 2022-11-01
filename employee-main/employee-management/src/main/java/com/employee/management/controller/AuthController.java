package com.employee.management.controller;

import com.employee.management.dto.JwtAuthResponse;
import com.employee.management.dto.LoginDto;
import com.employee.management.dto.RegisterDto;
import com.employee.management.model.Role;
import com.employee.management.model.User;
import com.employee.management.repository.RoleRepository;
import com.employee.management.repository.UserRepository;
import com.employee.management.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import javax.security.auth.login.LoginException;
import java.util.Collections;
import java.util.Optional;

@CrossOrigin(origins="http://127.0.0.1:5500")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> userLogin(@RequestBody LoginDto loginDto) {
            try{
                Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String token=jwtTokenProvider.generateToken(authentication);
                return ResponseEntity.ok(new JwtAuthResponse(token));
            }
            catch (AuthenticationException e){
                System.out.println(e.getMessage());
                return new ResponseEntity<JwtAuthResponse>(new JwtAuthResponse(e.getMessage()),HttpStatus.UNAUTHORIZED);
            }

    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDto registerDto) {
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            return new ResponseEntity<>("email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB

        // create user object
        User user = new User();
        user.setName(registerDto.getName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        Role roles = roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}
