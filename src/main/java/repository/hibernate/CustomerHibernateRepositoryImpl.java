package repository.hibernate;

import model.Account;
import model.Customer;
import org.hibernate.Session;
import repository.CustomerRepository;
import view.CustomerView;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class CustomerHibernateRepositoryImpl implements CustomerRepository {

    @Override
    public Customer saveToDB(Customer customer) {
        try (Session session = SessionCreator.getSession()) {
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
        }
        return customer;
    }

    @Override
    public List<Customer> getAllFromDB(String name) {
        List<Customer> listOfCustomers = new ArrayList<>();
        try (Session session = SessionCreator.getSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Customer where name=:name");
            query.setParameter("name", name);
            listOfCustomers = query.getResultList();
            session.getTransaction().commit();

        } catch (IllegalArgumentException e) {
            System.out.println("Customer not found!");
            e.printStackTrace();
        }
        return listOfCustomers;
    }

    @Override
    public Customer updateInDB(Customer customer) {
        try (Session session = SessionCreator.getSession()) {
            session.beginTransaction();
            Account account = customer.getAccount();
            account.setAccountValue(customer.getAccount().getAccountValue() + CustomerView.customerChangeAccountValue);
            session.update(customer);
            session.getTransaction().commit();

            System.out.println("Customer with name " + customer.getName() + " has found in DB, it`s ID = " + customer.getId());

        } catch (IllegalArgumentException e) {
            System.out.println("Customer not found!");
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer deleteInDB(Customer customer) {
        try (Session session = SessionCreator.getSession()) {
            session.beginTransaction();
            session.delete(customer);
            session.getTransaction().commit();

            System.out.println("Customer with name " + customer.getName() + " has found in DB, it`s ID = " + customer.getId());

        } catch (IllegalArgumentException e) {
            System.out.println("Customer not found!");
            e.printStackTrace();
        }
        return customer;
    }

}
