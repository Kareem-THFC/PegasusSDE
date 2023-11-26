package com.example.SpringBootPegasus.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Car")
@Getter
@Setter

public class car {
    @Id
    @SequenceGenerator(
            name ="car_sequence",
            sequenceName ="car_sequence",
                    allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator ="car_sequence"
    )
    private Long id;
    private String Model;
    private int production_year;
    private String brand;
    private String color;
    private int dailyRate;


    public car( String model, int year, String brand, String color, int dailyRate) {
        this.Model = model;
        this.production_year = year;
        this.brand = brand;
        this.color = color;
        this.dailyRate = dailyRate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", Model='" + Model + '\'' +
                ", production_year=" + production_year +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", dailyRate=" + dailyRate +
                '}';
    }

    public car() {

    }

}




