package com.example.SpringBootPegasus.Controllers;

import com.example.SpringBootPegasus.Entities.Rental;
import com.example.SpringBootPegasus.Services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/rental")
public class RentalController {

    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @CrossOrigin
    @GetMapping
    @ResponseBody
    public List<Rental> getRentals() {
        return rentalService.getRentals();
    }

    @CrossOrigin
    @PostMapping
    public void addNewRental(@RequestBody Rental rental) {
        rentalService.addNewRental(rental);
    }

    @CrossOrigin
    @DeleteMapping(path = "{rentalId}")
    public void deleteRental(@PathVariable("rentalId") Long rentalId) {
        rentalService.deleteRental(rentalId);
    }

    @CrossOrigin
    @PutMapping(path = "{rentalId}")
    public void updateRental(
            @PathVariable("rentalId") Long rentalId,
            @RequestParam(required = false) LocalDate rentalDate,
            @RequestParam(required = false) LocalDate returnDate,
            @RequestParam(required = false) Integer fullPrice
    ) {
        rentalService.updateRental(rentalId, rentalDate, returnDate, Optional.ofNullable(fullPrice));
    }
}
