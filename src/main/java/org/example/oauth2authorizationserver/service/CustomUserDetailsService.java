package org.example.oauth2authorizationserver.service;

import lombok.RequiredArgsConstructor;
import org.example.oauth2authorizationserver.entity.UserEntity;
import org.example.oauth2authorizationserver.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles(userEntity.getRole())
                .build();
    }
}
