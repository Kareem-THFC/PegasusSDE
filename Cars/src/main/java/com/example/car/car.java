package com.example.car;

import jakarta.persistence.*;

@Entity
@Table
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


    public car(Long id, String model, int year, String brand, String color, int dailyRate) {
        this.id = id;
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




    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getYear() {
        return production_year;
    }

    public void setYear(int year) {
        this.production_year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }

    public void setID(Long Id) {
        this.id = Id;
    }

    public  long getId() {
        return id;
    }
}




