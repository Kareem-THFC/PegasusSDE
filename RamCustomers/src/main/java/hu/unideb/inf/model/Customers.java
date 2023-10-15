package hu.unideb.inf.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Customers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Customer_id;
    private String First_Name;
    private String Last_Name;
    private String License_Number;
    private int Total_Rentals;

    public int getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.Customer_id = customer_id;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public String getLicense_Number() {
        return License_Number;
    }

    public void setLicense_Number(String license_Number) {
        License_Number = license_Number;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public int getTotal_Rentals() {
        return Total_Rentals;
    }

    public void setTotal_Rentals(int total_Rentals) {
        this.Total_Rentals = total_Rentals;
    }

}
