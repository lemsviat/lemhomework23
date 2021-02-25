package controller;

import model.Customer;
import repository.CustomerRepository;
import repository.hibernate.CustomerHibernateRepositoryImpl;

import java.util.List;

public class CustomerController {
    CustomerRepository customerRepository = new CustomerHibernateRepositoryImpl();

    public Customer saveCustomer(Customer customer) {
        return customerRepository.saveToDB(customer);
    }
    public List<Customer> readCustomer(String name) {
        return customerRepository.getAllFromDB(name);
    }
    public Customer updateCustomer(Customer customer) {
        return customerRepository.updateInDB(customer);
    }
    public Customer deleteCustomer(Customer customer) {
        return customerRepository.deleteInDB(customer);
    }

}
