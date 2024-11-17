package org.example.oauth2authorizationserver.service;

import lombok.RequiredArgsConstructor;
import org.example.oauth2authorizationserver.dto.UserDTO;
import org.example.oauth2authorizationserver.entity.UserEntity;
import org.example.oauth2authorizationserver.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void join(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntity.setNickname(userDTO.getNickname());
        userEntity.setPhone(userDTO.getPhone());
        userEntity.setRole("ADMIN");

        userRepository.save(userEntity);
    }
}
