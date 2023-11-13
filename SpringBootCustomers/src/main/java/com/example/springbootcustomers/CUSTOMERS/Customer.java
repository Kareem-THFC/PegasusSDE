package com.example.springbootcustomers.CUSTOMERS;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
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
            strategy = GenerationType.SEQUENCE,
            generator = "Customer_Sequence"
    )
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

    public void setCustomer_id(Long customer_id) {
        Customer_id = customer_id;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public void setLicense_Number(String license_Number) {
        License_Number = license_Number;
    }

    public Long getCustomer_id() {
        return Customer_id;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public String getLicense_Number() {
        return License_Number;
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
