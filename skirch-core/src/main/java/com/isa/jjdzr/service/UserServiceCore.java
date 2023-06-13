package com.isa.jjdzr.service;

import com.isa.jjdzr.dto.UserDto;
import com.isa.jjdzr.mappers.UserMapper;
import com.isa.jjdzr.model.User;
import com.isa.jjdzr.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceCore {

    private final ResortServiceCore resortServiceCore;

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserDto saveUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    public UserDto findByEmail(String email) {
        List<User> listOfUsers = Database.getListOfUsers();
        for (int i = 0; i < listOfUsers.size(); i++) {
            if (listOfUsers.get(i).getEmail().equals(email)) {
                return userRepository.findByEmail(email)
                        .map(userMapper::toDto)
                        .orElse(null);
            }
        }
        return null;

    }

    public void addToFavorites(Integer id) {
        User toUpdate = userRepository.findByEmail("jacek@wp.pl")
                .orElseThrow(() -> new RuntimeException("User not found"));
        toUpdate.getFavoriteResorts().add(resortServiceCore.findById(id));
        userRepository.save(toUpdate);
    }
}


