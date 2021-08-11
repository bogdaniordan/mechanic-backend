package com.mechanicservice.security;

import com.mechanicservice.model.Mechanic;
import com.mechanicservice.repository.MechanicRepository;
import com.mechanicservice.repository.UserRepository;
import com.mechanicservice.service.MechanicService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CustomUserCredentialsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final MechanicRepository mechanicRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userRepository.findByUsername(username).isPresent()) {
            com.mechanicservice.model.User user = userRepository.findByUsername(username).get();

            return new User(user.getUsername(), user.getPassword(),
                    user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
            );
        }

        Mechanic mechanic = mechanicRepository.getMechanicByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Mechanic with email: " + username + " not found!"));
        return new User(mechanic.getEmail(), mechanic.getPassword(),
                mechanic.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
        );

//        com.mechanicservice.model.User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + "not found!"));
//
//        return new User(user.getUsername(), user.getPassword(),
//                user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
//        );
    }

}
