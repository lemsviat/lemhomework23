package repository.hibernate;

import org.hibernate.Session;
import repository.AccountRepository;
import view.CustomerView;

public class SpecialtyHibernateRepositoryImpl implements AccountRepository {
    @Override
    public void create() {
        Session session = SessionFactoryCreator.getSessionFactory().getCurrentSession();
        String specialties = CustomerView.specialties.toString();
        session.beginTransaction();
        session.save(specialties);
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
