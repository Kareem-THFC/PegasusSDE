package com.example.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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

    public void deletecar(Long carid) {
        boolean exists = carRepository.existsById(carid);
        if (!exists) {
            throw new IllegalStateException(
                    "car with id" + carid + "does not exists");


        }





        }



    @Transactional
    public void updatecar(Long id, String model) {
        car car1= carRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("car with id " + id + " does not exist"));

        if (model != null && model.length() > 0 &&
                !Objects.equals(car1.getModel(), model)) {
            car1.setModel(model);
        }



        carRepository.save(car1);
    }

}
