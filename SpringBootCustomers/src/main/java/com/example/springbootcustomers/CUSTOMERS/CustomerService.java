package com.example.springbootcustomers.CUSTOMERS;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> customersByLicenseNumber =
                customerRepository.findCustomersByLicense_Number(customer.getLicense_Number());
        if(customersByLicenseNumber.isPresent()) {
            throw new IllegalStateException("License number is taken");
        }
        customerRepository.save(customer);
        System.out.println(customer);
    }

    public void deleteCustomer(Long id) {
        boolean exists = customerRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Customer with id " + id + " does not exist");
        }
        customerRepository.deleteById(id);
    }
    @Transactional
    public void updateCustomer(Long customerid, String firstName, String lastName, String licenseNumber) {
        Customer customer = customerRepository.findById(customerid)
                .orElseThrow(() -> new IllegalStateException(
                        "Customer with id " + customerid + " does not exist"));

        if (firstName != null &&
            firstName.length() > 0 &&
            !Objects.equals(customer.getFirst_Name(), firstName)){
            customer.setFirst_Name(firstName);
        }

        if (lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(customer.getLast_Name(), lastName)) {
            customer.setLast_Name(lastName);
        }
    }
}

