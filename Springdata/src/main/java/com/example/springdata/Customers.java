package com.example.springdata;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customers {

    @Id
    @GeneratedValue
    private Long customer_id;
    private String FirstName;
    private String LastName;
    private String LicenseNumber;

    public Customers(String firstName, String lastName, String licenseNumber) {
        FirstName = firstName;
        LastName = lastName;
        LicenseNumber = licenseNumber;
    }

    public Customers() {

    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getLicenseNumber() {
        return LicenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        LicenseNumber = licenseNumber;
    }

    public void setCustomer_id(Long customerId) {
        this.customer_id = customerId;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customer_id=" + customer_id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", LicenseNumber=" + LicenseNumber +
                '}';
    }
}
