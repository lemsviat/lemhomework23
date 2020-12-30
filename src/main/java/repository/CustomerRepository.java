package repository;

import model.Customer;

public interface CustomerRepository extends GenericRepository {
    Customer saveToDB(Customer customer);
    Customer readFromDB(String name);
    Customer updateInDB(Customer customer);
    Customer deleteInDB(Customer customer);
}
