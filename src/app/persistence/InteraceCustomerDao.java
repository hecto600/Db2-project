package app.persistence;

import java.sql.SQLException;
import java.util.List;

import app.model.Customer;

public interface InteraceCustomerDao {
    public List<Customer> visualizeAllCustomer() throws SQLException;
    public Customer visualizeCustomer(Customer c) throws SQLException;
    public void updateCustomer(Customer c) throws SQLException;
    public void insertCustomer(Customer c) throws SQLException;
    public void removeCustomer(Customer c) throws SQLException;

}
