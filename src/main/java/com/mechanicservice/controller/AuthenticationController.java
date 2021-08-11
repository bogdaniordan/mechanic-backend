package com.mechanicservice.controller;


import com.mechanicservice.dto.MechanicCredentials;
import com.mechanicservice.dto.MechanicLoginResponse;
import com.mechanicservice.dto.UserCredentials;
import com.mechanicservice.dto.UserLoginResponse;
import com.mechanicservice.model.Mechanic;
import com.mechanicservice.model.User;
import com.mechanicservice.repository.MechanicRepository;
import com.mechanicservice.repository.UserRepository;
import com.mechanicservice.security.JwtTokenService;
import com.mechanicservice.service.CustomerService;
import com.mechanicservice.service.MechanicService;
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
//@RequestMapping("/users")
@AllArgsConstructor
public class AuthenticationController {

    private final CustomerService customerService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final MechanicService mechanicService;

    @PostMapping("/users/register")
    public ResponseEntity<String> register(@RequestBody UserCredentials form) {
        try {
            User user = User.builder().username(form.getUsername())
                    .password(BCrypt.hashpw(form.getPassword(), BCrypt.gensalt(12)))
                    .roles(List.of("ROLE_USER"))
                    .firstName(form.getFirstName())
                    .secondName(form.getSecondName())
                    .build();
            userRepository.save(user);
            return ResponseEntity.ok("User account created!");
        } catch (Exception e) {
            throw new BadCredentialsException("Account could not be created!");
        }
    }

    @PostMapping("/mechanics/register")
    public ResponseEntity<String> register(@RequestBody Mechanic mechanic) {
        try {
            mechanic.setRoles(List.of("ROLE_USER", "ROLE_ADMIN"));
            mechanicService.save(mechanic);
            return ResponseEntity.ok("Mechanic account created!");
        } catch (Exception e) {
            throw new BadCredentialsException("Account could not be created!");
        }
    }

    @PostMapping("/mechanics/login")
    public ResponseEntity<MechanicLoginResponse> login(@RequestBody MechanicCredentials form) {
        try {
            String email = form.getEmail();

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, form.getPassword())
            );

            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            String token = jwtTokenService.createToken(email, roles);

            MechanicLoginResponse response = MechanicLoginResponse.builder()
                            .email(email)
                                    .id(mechanicService.getMechanicIdByEmail(email))
                                            .roles(roles)
                                                    .token(token)
                                                            .build();

            System.out.println(response.toString());

            return ResponseEntity.ok(response);

        } catch (UsernameNotFoundException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

    @PostMapping("/users/login")
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

            System.out.println(response.toString());

            return ResponseEntity.ok(response);

        } catch (UsernameNotFoundException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

    @GetMapping("/users/get-fullname/{username}")
    public ResponseEntity<String> getUserFullName(@PathVariable String username) {
        log.info("Getting full name of user with username: " + username);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Could not find user with username: " + username));
        return new ResponseEntity<>(user.getFirstName() + " " + user.getSecondName(), HttpStatus.OK);
    }
}
