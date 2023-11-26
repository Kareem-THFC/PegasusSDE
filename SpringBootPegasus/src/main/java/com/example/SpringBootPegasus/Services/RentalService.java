package com.example.SpringBootPegasus.Services;

import com.example.SpringBootPegasus.Entities.Rental;
import com.example.SpringBootPegasus.Repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> getRentals() {
        return rentalRepository.findAll();
    }

    public void addNewRental(Rental rental) {
        rentalRepository.save(rental);
    }

    public void deleteRental(Long rentalId) {
        boolean exists = rentalRepository.existsById(rentalId);
        if (!exists) {
            throw new IllegalStateException("Rental with id " + rentalId + " does not exist");
        }
        rentalRepository.deleteById(rentalId);
    }

    public void updateRental(Long rentalId, LocalDate rentalDate, LocalDate returnDate, Optional<Integer> fullPrice) {
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new IllegalStateException("Rental with id " + rentalId + " does not exist"));

        if (rentalDate != null) {
            rental.setRental_Date(rentalDate);
        }

        if (returnDate != null) {
            rental.setReturn_Date(returnDate);
        }

        fullPrice.ifPresent(rental::setFull_Price);

        rentalRepository.save(rental);
    }
}
