package com.mechanicservice.controller;


import com.mechanicservice.dto.UserCredentials;
import com.mechanicservice.dto.UserLoginResponse;
import com.mechanicservice.model.User;
import com.mechanicservice.repository.UserRepository;
import com.mechanicservice.security.JwtTokenService;
import com.mechanicservice.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
@RequestMapping("/users")
@AllArgsConstructor
public class AuthenticationController {

    private final CustomerService customerService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserCredentials form) {
        try {
            User user = User.builder().username(form.getUsername())
                    .password(BCrypt.hashpw(form.getPassword(), BCrypt.gensalt(12)))
                    .roles(List.of("ROLE_USER"))
                    .firstName(form.getFirstName())
                    .secondName(form.getSecondName())
                    .build();
            userRepository.save(user);
            return ResponseEntity.ok("Account created!");
        } catch (Exception e) {
            throw new BadCredentialsException("Accound could not be created!");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserCredentials form) {
        try {
            String username = form.getUsername();

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, form.getPassword())
            );

            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            String token = jwtTokenService.createToken(username, roles);

            UserLoginResponse response = UserLoginResponse.builder()
                    .username(username)
                    .customerId(customerService.getCustomerIdByUsername(username))
                    .roles(roles)
                    .token(token)
                    .build();

            log.info(response.toString());

            return ResponseEntity.ok(response);

        } catch (UsernameNotFoundException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

    @GetMapping("/get-fullname/{username}")
    public ResponseEntity<String> getUserFullName(@PathVariable String username) {
        log.info("Getting full name of user with username: " + username);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Could not find user with username: " + username));
        return new ResponseEntity<>(user.getFirstName() + " " + user.getSecondName(), HttpStatus.OK);
    }
}
