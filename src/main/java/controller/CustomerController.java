package controller;

import model.Customer;
import repository.CustomerRepository;
import repository.GenericRepository;
import repository.hibernate.CustomerHibernateRepositoryImpl;
import view.*;

public class CustomerController {
    //GenericRepository customerRepository=new CustomerRepositoryImpl();
    CustomerRepository customerRepository = new CustomerHibernateRepositoryImpl();

    public void create() {
        //customerRepository.create();
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

    public Customer saveCustomer(Customer customer) {
        customerRepository.saveToDB(customer);
        return customer;
    }

    public Customer readCustomer(String name) {
        return customerRepository.readFromDB(name);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.updateInDB(customer);
    }

    public Customer deleteCustomer(Customer customer) {
        return customerRepository.deleteInDB(customer);
    }

}
