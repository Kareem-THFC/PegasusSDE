package com.example.car;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class carConfig {

    CommandLineRunner commandLineRunner(carRepository repository) {
        return args -> {
           car Benz = new car(
                   001L,
                    "Benz",
                    2021,
                    "Mercedes",
                    "blue",
                    011
            );
            car Honda = new car(2L, "Civic", 2022, "Honda", "Red",043);
            car Mustang = new car(3L, "Mustang", 2021, "Ford", "Yellow",043);
            car Silver = new car(4L, "Camry", 2020, "Toyota", "Silver",99);
            car Ford = new car(5L, "F150", 2023, "Ford", "Black",043);
            car White = new car(6L, "Accord", 2022, "Honda", "White",123);
            car Toyota= new car(7L, "Corolla", 2023, "Toyota", "Green",032);
           car Jeep= new car(9L, "Cherokee", 2022, "Jeep", "Brown",123);
            car Camry = new car(10L, "Wrangler", 2023, "Camry", "Orange",123);
repository.saveAll(
        List.of(Benz,Honda,Mustang,Silver,Ford,White,Toyota,Jeep,Camry)
);
        };
    }
}
