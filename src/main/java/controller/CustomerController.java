package controller;

import model.Customer;
import repository.CustomerRepository;
import repository.hibernate.CustomerHibernateRepositoryImpl;

public class CustomerController {
    CustomerRepository customerRepository = new CustomerHibernateRepositoryImpl();

    public Customer saveCustomer(Customer customer) {
        return customerRepository.saveToDB(customer);
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
