package com.isa.jjdzr.service;

import com.isa.jjdzr.dto.UserDto;
import com.isa.jjdzr.mappers.UserMapper;
import com.isa.jjdzr.model.User;
import com.isa.jjdzr.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    @Autowired
    private final UserMapper userMapper;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserDto saveUser(UserDto userDto) {
        if(userRepository.existsByEmail(userDto.getEmail())){
            throw new RuntimeException("User already exists");
        }
        User user = userMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User savedUser = userRepository.saveAndFlush(user);
        return userMapper.toDto(savedUser);
    }

    public UserDto findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toDto)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}


