package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaCustomersDAO implements CustomersDAO {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveCustomer(Customers a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteCustomer(Customers a) {
        entityManager.getTransaction().begin();
        entityManager.remove(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateCustomer(Customers a) {
        /*entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();*/
        saveCustomer(a);
    }

    @Override
    public List<Customers> getCustomer() {
        TypedQuery<Customers> query = entityManager.createQuery(
                "SELECT a FROM Customers a", Customers.class);
        List<Customers> customers = query.getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Run run) {
        entityManager.getTransaction().begin();
        entityManager.persist(run);
        entityManager.getTransaction().commit();
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
