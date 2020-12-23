package controller;

import repository.GenericRepository;
import repository.hibernate.CustomerHibernateRepositoryImpl;
import view.*;

public class CustomerController {
    //GenericRepository customerRepository=new CustomerRepositoryImpl();
    GenericRepository customerRepository = new CustomerHibernateRepositoryImpl();

    public void create() {
        customerRepository.create();
    }

    public void read() {
        customerRepository.read();
    }

    public void update() {
        //System.out.println("Обновляются данные клиента с именем - " + CustomerView.customerName);
        customerRepository.update();
    }

    public void delete() {
        //System.out.println("Удаляется с базы клиент с именем - " + CustomerView.customerName);
        customerRepository.delete();
    }
}
