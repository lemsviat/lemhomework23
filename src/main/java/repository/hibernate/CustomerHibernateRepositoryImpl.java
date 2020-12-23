package repository.hibernate;

import model.Account;
import model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import repository.AccountRepository;
import view.CustomerView;
import view.SessionFactoryCreator;


public class CustomerHibernateRepositoryImpl implements AccountRepository {
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
            Account account=customer.getAccount();
            account.setAccountValue(customer.getAccount().getAccountValue()+CustomerView.customerChangeAccountValue);
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
