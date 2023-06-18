package com.isa.jjdzr.security;

import com.isa.jjdzr.mappers.UserMapper;
import com.isa.jjdzr.model.User;
import com.isa.jjdzr.repositories.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value="userServiceDetails")
@Data
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("LOAD USER BY NAME");
        Optional<User> user = userRepository.findByEmail(email);
        System.out.println(user);
        return new UserDetails(user
                .map(userMapper::toDto)
                .orElse(null));
    }
}
