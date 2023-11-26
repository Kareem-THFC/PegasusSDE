package com.example.SpringBootPegasus.Repositories;


import com.example.SpringBootPegasus.Entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {


}
