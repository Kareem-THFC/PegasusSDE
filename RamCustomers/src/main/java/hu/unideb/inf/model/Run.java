package hu.unideb.inf.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Run {
    @Id
    @GeneratedValue
    private int Customer_id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Customers> customers = new ArrayList<>();
    public List<Customers> getCustomer() {
        return customers;
    }
    public void setAnimals(List<Customers> customers) {
        this.customers = customers;
    }
}
