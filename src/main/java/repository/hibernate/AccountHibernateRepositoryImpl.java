package repository.hibernate;

import model.Account;
import org.hibernate.Session;
import repository.AccountRepository;
import view.AccountView;
import view.SessionFactoryCreator;

public class AccountHibernateRepositoryImpl implements AccountRepository {
    @Override
    public void create() {
        Session session = SessionFactoryCreator.getSessionFactory().getCurrentSession();
        Account account = AccountView.customerAccount;
        System.out.println(account);
        session.beginTransaction();
        session.save(account);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void read() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
