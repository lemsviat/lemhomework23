package repository;

import model.Customer;

import java.util.List;

public interface CustomerRepository extends GenericRepository {
    Customer saveToDB(Customer customer);
    List<Customer> getAllFromDB(String name);
    Customer updateInDB(Customer customer);
    Customer deleteInDB(Customer customer);
}
