package com.isa.jjdzr.repositories;

import com.isa.jjdzr.dto.UserDto;
import com.isa.jjdzr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmail (String givenEmail);
}
