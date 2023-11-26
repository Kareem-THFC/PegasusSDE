package com.example.SpringBootPegasus.Entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
@Builder
@Data
public class Customer {
    @Id
    @SequenceGenerator(
            name="Customer_Sequence",
            sequenceName="Customer_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "Customer_Sequence"
    )
    @Column(name = "customer_id")
    private Long Customer_id;

    private String First_Name;
    private String Last_Name;
    private String License_Number;


    public Customer() {
    }

    public Customer(Long customer_id, String first_Name, String last_Name, String license_Number) {
        Customer_id = customer_id;
        First_Name = first_Name;
        Last_Name = last_Name;
        License_Number = license_Number;
    }

    public Customer(String first_Name, String last_Name, String license_Number) {
        First_Name = first_Name;
        Last_Name = last_Name;
        License_Number = license_Number;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Customer_id='" + Customer_id + '\'' +
                ", First_Name='" + First_Name + '\'' +
                ", Last_Name='" + Last_Name + '\'' +
                ", License_Number='" + License_Number + '\'' +
                '}';
    }

}
