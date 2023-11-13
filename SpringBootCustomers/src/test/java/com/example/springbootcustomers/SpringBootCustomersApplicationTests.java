package com.example.springbootcustomers;

import com.example.springbootcustomers.CUSTOMERS.Customer;
import com.example.springbootcustomers.CUSTOMERS.CustomerConfig;
import com.example.springbootcustomers.CUSTOMERS.CustomerRepository;
import com.example.springbootcustomers.CUSTOMERS.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.assertj.core.api.Assertions;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class SpringBootCustomersApplicationTests {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void contextLoads() {
        customerRepository.save(
                Customer.builder()
                        .First_Name("Tom")
                        .Last_Name("Smith")
                        .License_Number("AAC 567")
                        .build()
        );
    }

    @Test
    void testUpdateCustomer(){
        Customer customer = Customer.builder()
                .First_Name("Alex").License_Number("GBE 523").build();
        Customer c1 = customerRepository.save(customer);
        c1.setLicense_Number("GBE 112");
        Customer p2 = customerRepository.save(c1);
        Assertions.assertThat(p2.getLicense_Number()).isEqualTo("GBE 112");
    }
}
