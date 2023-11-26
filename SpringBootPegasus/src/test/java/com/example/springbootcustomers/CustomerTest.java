package com.example.springbootcustomers;

import com.example.SpringBootPegasus.Application;
import com.example.SpringBootPegasus.Entities.Customer;
import com.example.SpringBootPegasus.Repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = Application.class)
public class CustomerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSaveAndGetCustomer() {
        Customer customer = new Customer("Jessica", "WaterSon", "KKL 123");
        customerRepository.save(customer);

        List<Customer> customers = customerRepository.findAll();
        assertThat(customers).contains(customer);
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = new Customer("KLJD", "KSAL", "ASDJ123");
        customerRepository.save(customer);

        customer.setLast_Name("JKA");
        customer.setFirst_Name("John");
        customer.setLicense_Number("8784 jkh");
        customerRepository.save(customer);

        Optional<Customer> updatedCustomer = customerRepository.findById(customer.getCustomer_id());
        assertThat(updatedCustomer).isPresent().hasValueSatisfying(c -> assertThat(c.getLast_Name()).isEqualTo("JKA"));
        assertThat(updatedCustomer).isPresent().hasValueSatisfying(c -> assertThat(c.getFirst_Name()).isEqualTo("John"));
        assertThat(updatedCustomer).isPresent().hasValueSatisfying(c -> assertThat(c.getLicense_Number()).isEqualTo("8784 jkh"));

    }

    @Test
    public void testDeleteCustomer() {

        Customer customer = new Customer("John", "Doe", "ABC123");

        customerRepository.save(customer);

        customerRepository.deleteById(customer.getCustomer_id());

        Optional<Customer> deletedCustomer = customerRepository.findById(customer.getCustomer_id());
        assertFalse(deletedCustomer.isPresent());
    }

    @Test
    public void testCountCustomers() {

        long initialCustomerCount = customerRepository.count(); //gets initial count

        Customer customer1 = new Customer("Alice", "Johnson", "123ABC");
        Customer customer2 = new Customer("Bob", "Williams", "456XYZ");

        customerRepository.saveAll(List.of(customer1, customer2));

        long updatedCustomerCount = customerRepository.count();
        long expectedCustomerCount = initialCustomerCount + 2;  //ensures added customers are initial+2
        assertThat(updatedCustomerCount).isEqualTo(expectedCustomerCount);
    }

    @Test
    public void testFindCustomerByLicenseNumber() {


        Customer customer = new Customer("Michael", "Jordan", "MJ123");
        customerRepository.save(customer);

        Optional<Customer> foundCustomer = customerRepository.findCustomersByLicense_Number("MJ123");

        assertThat(foundCustomer).isPresent().hasValueSatisfying(c ->
                assertThat(c.getFirst_Name()).isEqualTo("Michael")
        );

    }

}

