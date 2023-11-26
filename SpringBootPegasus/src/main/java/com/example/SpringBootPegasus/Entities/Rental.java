package com.example.SpringBootPegasus.Entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "rental")
@Getter
@Setter
public class Rental {

    @Id
    @SequenceGenerator(
        name="Rental_Sequence",
        sequenceName ="Rental_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator ="Rental_Sequence"
    )
    @Column(name = "rental_id")
    private Long Rental_ID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "first_name")
    @JoinColumn(referencedColumnName = "last_name")
    private Customer customer;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "model")
    @JoinColumn(referencedColumnName = "brand")
    private car car1;

    private LocalDate Rental_Date;
    private LocalDate Return_Date;
    private Integer Full_Price;

    public Rental(car car1, Customer customer, LocalDate rental_Date, LocalDate return_Date, Integer full_Price) {
        this.car1 = car1;
        this.customer = customer;
        Rental_Date = rental_Date;
        Return_Date = return_Date;
        Full_Price = full_Price;
    }

    public Rental() {
    }
    @Override
    public String toString() {
        return "Rental{" +
                "Rental_ID=" + Rental_ID +
                ", Rental_Date=" + Rental_Date +
                ", Return_Date=" + Return_Date +
                ", Full_Price=" + Full_Price +
                '}';
    }
}
