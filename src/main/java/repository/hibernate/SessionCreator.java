package repository.hibernate;

import model.Account;
import model.Customer;
import model.Specialty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionCreator {
    public static SessionFactory factory;
    public static Session session;

    private SessionCreator() {
    }

    public static synchronized Session getSession() {

        if (factory == null) {
            factory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Account.class)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Specialty.class)
                    .buildSessionFactory();
        }
        System.out.println("SessionFactory created");
        session = factory.getCurrentSession();
        return session;
    }
}
