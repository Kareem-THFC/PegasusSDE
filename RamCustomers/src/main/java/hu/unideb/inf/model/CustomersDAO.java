package hu.unideb.inf.model;

import java.util.List;

public interface CustomersDAO extends AutoCloseable{
    //CRUD methods
    public void saveCustomer(Customers a);
    public void deleteCustomer(Customers a);
    public void updateCustomer(Customers a);
    public List<Customers> getCustomer(); //Retrieve
    public default void saveCustomer(Run run){
        throw new UnsupportedOperationException();
    }
}
