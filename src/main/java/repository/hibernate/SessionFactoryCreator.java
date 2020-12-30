package repository.hibernate;

import model.Account;
import model.Customer;
import model.Specialty;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryCreator {
    public static SessionFactory factory;

    private SessionFactoryCreator() {
    }
    public static synchronized SessionFactory getSessionFactory() {

        if (factory == null) {
            factory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Account.class)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Specialty.class)
                    .buildSessionFactory();
        }
        System.out.println("SessionFactory created");
        return factory;
    }

}
