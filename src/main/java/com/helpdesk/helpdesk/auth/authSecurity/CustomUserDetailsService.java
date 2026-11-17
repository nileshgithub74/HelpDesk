package com.helpdesk.helpdesk.auth.authSecurity;

import com.helpdesk.helpdesk.user.entity.User;
import com.helpdesk.helpdesk.user.enums.UserStatus;
import com.helpdesk.helpdesk.user.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Locale;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(
                email.trim().toLowerCase(Locale.ROOT)).orElseThrow(() -> {
            throw new UsernameNotFoundException("user not found");

        });

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities("ROLE_" + user.getRole().name())
                .disabled(user.getStatus() != UserStatus.ACTIVE)
                .build();


    }
}
