package com.example.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface carRepository
        extends JpaRepository<car,Long> {

     Optional<car> findByid(Long id);


}

