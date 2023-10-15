package hu.unideb.inf;

import java.sql.SQLException;

import hu.unideb.inf.model.*;
import org.h2.tools.Server;

public class Application {

    public static void main(String[] args) throws SQLException {
        startDatabase();

        //try-with-resources
        try (CustomersDAO aDAO = new JpaCustomersDAO()) {
            handleData(aDAO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:mem:my_ram123");
        System.out.println("User Name: sa");
        System.out.println("Password: ");
    }

    public static void handleData(CustomersDAO aDAO){
        Customers a = new Customers();
        a.setFirst_Name("Rami");
        a.setTotal_Rentals(4);
        a.setLast_Name("Gergly");
        a.setLicense_Number("BBC 445");

        Customers a2 = new Customers();
        a2.setFirst_Name("George");
        a2.setTotal_Rentals(2);
        a2.setLast_Name("Washington");
        a2.setLicense_Number("AAC 214");

        Customers a3 = new Customers();
        a3.setLicense_Number("GBF 324");
        a3.setFirst_Name("Ben");
        a3.setLast_Name("Tyson");
        a3.setTotal_Rentals(5);

        Customers a4 = new Customers();
        a4.setTotal_Rentals(6);
        a4.setLicense_Number("KHF 124");
        a4.setFirst_Name("Donald");
        a4.setLast_Name("Johnson");

        Run run = new Run();
        run.getCustomer().add(a);
        run.getCustomer().add(a2);
        run.getCustomer().add(a3);
        run.getCustomer().add(a4);
        aDAO.saveCustomer(run);
    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
