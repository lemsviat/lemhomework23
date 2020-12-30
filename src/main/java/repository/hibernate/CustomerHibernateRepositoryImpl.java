package repository.hibernate;

import model.Account;
import model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import repository.AccountRepository;
import repository.CustomerRepository;
import view.CustomerView;


public class CustomerHibernateRepositoryImpl implements CustomerRepository {
    @Override
    public void create() {
        try (Session session = SessionFactoryCreator.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            Customer customer = new Customer(CustomerView.customerName);
            customer.setAccount(CustomerView.customer.getAccount());
            customer.setSpecialties(CustomerView.specialties);
            System.out.println(customer);

            session.save(customer);
            session.getTransaction().commit();

            System.out.println("Customer added to DB");

        }
    }

    @Override
    public Customer saveToDB(Customer customer) {
        try (Session session = SessionFactoryCreator.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
        }
        return customer;
    }

    @Override
    public Customer readFromDB(String name) {
        Customer customer = new Customer();
        try (Session session = SessionFactoryCreator.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Customer.class);
            customer = (Customer) criteria.add(Restrictions.eq("name", name))
                    .uniqueResult();
            session.getTransaction().commit();

            System.out.println("Customer with name " + name + " has found in DB, it`s ID = " + customer.getId());

        } catch (IllegalArgumentException e) {
            System.out.println("Customer not found!");
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer updateInDB(Customer customer) {
        try (Session session = SessionFactoryCreator.getSessionFactory().getCurrentSession()) {
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
        try (Session session = SessionFactoryCreator.getSessionFactory().getCurrentSession()) {
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

    @Override
    public void read() {
        try (Session session = SessionFactoryCreator.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Customer.class);
            Customer customer = (Customer) criteria.add(Restrictions.eq("name", CustomerView.customerName))
                    .uniqueResult();
            System.out.println(customer);
            session.getTransaction().commit();

            System.out.println("Customer has red from DB");

        } catch (IllegalArgumentException e) {
            System.out.println("Customer not found!");
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        try (Session session = SessionFactoryCreator.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Customer.class);
            Customer customer = (Customer) criteria.add(Restrictions.eq("name", CustomerView.customerName))
                    .uniqueResult();
            Account account = customer.getAccount();
            account.setAccountValue(customer.getAccount().getAccountValue() + CustomerView.customerChangeAccountValue);
            customer.setAccount(account);

            session.update(customer);
            session.getTransaction().commit();

            System.out.println("Customer updated");

        } catch (IllegalArgumentException e) {
            System.out.println("Customer not found!");
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        try (Session session = SessionFactoryCreator.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Customer.class);
            Customer customer = (Customer) criteria.add(Restrictions.eq("name", CustomerView.customerName))
                    .uniqueResult();

            session.delete(customer);
            session.getTransaction().commit();

            System.out.println("Customer deleted from DB");

        } catch (IllegalArgumentException e) {
            System.out.println("Customer not found!");
            e.printStackTrace();
        }
    }
}
