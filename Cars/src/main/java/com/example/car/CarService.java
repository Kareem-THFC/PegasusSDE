package com.example.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CarService {
    private final carRepository carRepository;
@Autowired
    public CarService(com.example.car.carRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<car> getCar() {
        return carRepository.findAll();


    }

    public void addNewcar(car car1) {
        Optional<car> carOptional = carRepository
                .findByid(car1.getId());
        if(carOptional.isPresent()){
            throw new IllegalStateException("Id taken");
        }
    carRepository.save(car1);
    System.out.println(car1);
    }
}
