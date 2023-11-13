    package com.example.springbootcustomers.CUSTOMERS;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping(path = "api/v1/customer")
    public class CustomerController {

        private final CustomerService customerService;

        @Autowired
        public CustomerController(CustomerService customerService) {
            this.customerService = customerService;
        }

        @GetMapping
        public List<Customer> getCustomers() {
            return customerService.getCustomers();
        }

        @PostMapping
        public void registerNewCustomer(@RequestBody Customer customer) {
            customerService.addNewCustomer(customer); // Call the instance method on customerService
        }
        @DeleteMapping(path = "{customerid}")
        public void deleteCustomer(
                @PathVariable("customerid") Long id) {
            customerService.deleteCustomer(id);
        }

        @PutMapping(path = "{customerid}")
        public void updateCustomer(
                @PathVariable("customerid") Long customerid,
                @RequestParam(required = false) String First_name,
                @RequestParam(required = false) String Last_name,
                @RequestParam(required = false) String License_Number){
                    customerService.updateCustomer(customerid, First_name, Last_name, License_Number);
        }


    }
