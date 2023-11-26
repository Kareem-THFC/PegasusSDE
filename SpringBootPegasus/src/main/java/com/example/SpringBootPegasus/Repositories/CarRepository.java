package com.example.SpringBootPegasus.Repositories;

import com.example.SpringBootPegasus.Entities.car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository
        extends JpaRepository<car,Long> {

     Optional<car> findByid(Long id);


}

