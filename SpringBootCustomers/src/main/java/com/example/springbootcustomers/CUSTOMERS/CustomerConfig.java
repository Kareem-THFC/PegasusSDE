package com.example.springbootcustomers.CUSTOMERS;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository) {
        return args -> {

            Customer George = new Customer(
                            "George", "Washington", "AAE 556"
            );

            Customer Alex = new Customer(
                            "Alex", "Bellingham", "GBE 523"
            );

            Customer Rami = new Customer(
                           "Rami", "Kaawache", "BFR 427"
            );
            Customer Kareem = new Customer(
                    "Kareem", "Hamdan", "YCR 417"
            );
            Customer Moses = new Customer(
                    "Jack", "Simpson", "RAR 126"
            );
            Customer Emilia = new Customer(
                    "Emilia", "Velez", "BAW 445"
            );
            Customer Jessica = new Customer(
                    "Jessica", "Potter", "OTA 467"
            );
            Customer Yosef = new Customer(
                    "Yosef", "Bruce", "OTP 193"
            );
            Customer Lina = new Customer(
                    "Lina", "Crawford", "OTU 842"
            );
            Customer Jack = new Customer(
                    "Jack", "Golden", "EXE 827"
            );
            Customer Robin = new Customer(
                    "Robin", "Dover", "ABC 923"
            );
            Customer John = new Customer(
                    "John", "Hardin", "RAM 293"
            );
            Customer Tessa = new Customer(
                    "Tessa", "Gates", "JGF 392"
            );
            Customer Mia = new Customer(
                    "Mia", "Yang", "KLD 731"
            );
            Customer Monica = new Customer(
                    "Monica", "Brown", "LKN 472"
            );

                   repository.saveAll(
                           List.of(George, Alex, Rami, Emilia, Jack, Mia, Jessica,
                                   John, Kareem, Lina, Moses, Tessa, Monica,
                                   Robin, Yosef)
                   );
        };

    }
 }
