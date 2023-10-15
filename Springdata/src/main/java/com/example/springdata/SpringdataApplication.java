package com.example.springdata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdataApplication.class, args);
    }

    @Bean
    public CommandLineRunner run (CustomersRepository repository) {

        return (args -> {
            insertJavaAdvocates(repository);
            System.out.println(repository.findAll());
        });
    }

    private void insertJavaAdvocates(CustomersRepository repository) {

        repository.save(new Customers("Rami", "Kaawache", "AAB 123"));
        repository.save(new Customers("Kareem", "Hamdan", "BBC 383" ));
        repository.save(new Customers("john", "Doe", "YYR 322"));



    }
}
