package app.controller;

import java.sql.SQLException;

import app.model.Customer;

public interface InterfaceCustomerController {
    public Customer insertCustomer(Customer c) throws ClassNotFoundException, SQLException;
    public Customer updateCustomer(Customer c) throws ClassNotFoundException, SQLException;
    public Customer removeCustomer(Customer c) throws ClassNotFoundException, SQLException;
    public Customer visualizeCustomer(Customer c) throws ClassNotFoundException, SQLException;
    public String visualizeAllCustomers() throws ClassNotFoundException, SQLException;


}
