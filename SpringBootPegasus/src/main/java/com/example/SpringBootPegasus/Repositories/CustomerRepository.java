package com.example.SpringBootPegasus.Repositories;

import com.example.SpringBootPegasus.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c WHERE c.License_Number = :licenseNumber")
    Optional<Customer> findCustomersByLicense_Number(@NonNull String licenseNumber);


}
