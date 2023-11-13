package com.example.springbootcustomers.CUSTOMERS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //A function to find a Customer by their respective License Plate.
    @Query("SELECT c FROM Customer c WHERE c.License_Number = ?1") //JPQL COMMAND.
    Optional<Customer> findCustomersByLicense_Number(String licenseNumber);


}
