package com.isa.jjdzr.repositories;

import com.isa.jjdzr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail (String givenEmail);

    boolean existsByEmail(String email);

}
