package com.isa.jjdzr.repositories;

import com.isa.jjdzr.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResortRepository extends JpaRepository<Data,Integer> {

    @Query("SELECT COUNT(r) = 0 FROM Data r")
    boolean isEmpty();

}
