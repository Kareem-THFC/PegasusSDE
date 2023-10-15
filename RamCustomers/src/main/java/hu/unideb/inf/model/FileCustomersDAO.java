package hu.unideb.inf.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCustomersDAO implements CustomersDAO {

    private List<Customers> customers;

    public FileCustomersDAO() {
        //deserialization
        try (FileInputStream fis = new FileInputStream("customers.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);){
            customers = (List<Customers>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            customers = new ArrayList<>();
        }
    }

    /**
     Serializes the list of customers
     */
    private void serialize(){
        try (FileOutputStream fos = new FileOutputStream("customers.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);){
            oos.writeObject(customers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveCustomer(Customers a) {
        if (!customers.contains(a)) customers.add(a);
        serialize();
    }

    @Override
    public void deleteCustomer(Customers a) {
        customers.remove(a);
        serialize();
    }

    @Override
    public void updateCustomer(Customers a) {
        customers.remove(a);
        customers.add(a);
        serialize();
    }

    @Override
    public List<Customers> getCustomer() {
        return customers;
    }

    @Override
    public void close() throws Exception {
        serialize();
    }
}
