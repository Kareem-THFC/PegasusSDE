package com.example.SpringBootPegasus.Services;

import com.example.SpringBootPegasus.Entities.car;
import com.example.SpringBootPegasus.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


@Service
public class CarService {
    private final CarRepository carRepository;
@Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<car> getCar() {
        return carRepository.findAll();
    }

    @Transactional
    public void addNewcar(car car1) {
        carRepository.save(car1);
    }

    @Transactional
    public void deletecar(Long carid) {
        boolean exists = carRepository.existsById(carid);
        if (!exists) {
            throw new IllegalStateException("Car with id " + carid + " does not exist");
        }
        carRepository.deleteById(carid); // Perform the actual deletion
    }
    @Transactional
    public void updatecar(Long id, String model,String brand, String color, int dailyRate) {
        car car1= carRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("car with id " + id + " does not exist"));

        if (model != null && model.length() > 0 &&
                !Objects.equals(car1.getModel(), model)) {
            car1.setModel(model);
        }

        if (brand!= null && brand.length() > 0 &&
                !Objects.equals(car1.getBrand(), brand)) {
            car1.setBrand(brand);
        }

        if (dailyRate!= 0 &&
                !Objects.equals(car1.getDailyRate(), dailyRate)) {
            car1.setDailyRate(dailyRate);
        }

        if(color!= null && color.length() > 0 &&
                !Objects.equals(car1.getColor(), color)) {
            car1.setColor(color);
        }

        carRepository.save(car1);
    }

}
