package app.persistence;

import java.sql.SQLException;
import java.util.List;

import app.model.Customer;

public interface InterfaceCustomerDao {
    public List<Customer> visualizeAllCustomers() throws SQLException;
    public Customer visualizeCustomer(Customer c) throws SQLException;
    public Customer updateCustomer(Customer c) throws SQLException;
    public Customer insertCustomer(Customer c) throws SQLException;
    public Customer removeCustomer(Customer c) throws SQLException;

}
