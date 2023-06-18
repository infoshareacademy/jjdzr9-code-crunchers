package com.isa.jjdzr.service;

import com.isa.jjdzr.dto.UserDto;
import com.isa.jjdzr.mappers.UserMapper;
import com.isa.jjdzr.model.Data;
import com.isa.jjdzr.model.User;
import com.isa.jjdzr.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserServiceCore {

    private final ResortServiceCore resortServiceCore;

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserDto saveUser(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new IllegalArgumentException("User already exists");
        }
        User user = userMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    public UserDto findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toDto)
                .orElse(null);
    }

    public void addToFavorites(Integer id, UserDto userDto) {
        User toUpdate = userRepository.findByEmail(userDto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        toUpdate.getFavoriteResorts().add(resortServiceCore.findById(id));
        userRepository.save(toUpdate);
    }

    public Set<Data> getFavorites(UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getFavoriteResorts();

    }

    public void deleteResortFromFavorites(UserDto userDto, Long resortId) {
        User user = userRepository.findByEmail(userDto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        getFavorites(userMapper.toDto(user)).remove(resortId);
    }

}


