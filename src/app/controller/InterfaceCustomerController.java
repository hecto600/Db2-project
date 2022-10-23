package app.controller;

import java.sql.SQLException;

import app.model.Customer;

public interface InterfaceCustomerController {
    public void insertCustomer(Customer c) throws ClassNotFoundException, SQLException;
    public void updateCustomer(Customer c) throws ClassNotFoundException, SQLException;
    public void removeCustomer(Customer c) throws ClassNotFoundException, SQLException;
    public void visualizeCustomer(Customer c) throws ClassNotFoundException, SQLException;
    public void visualizeAllCustomers() throws ClassNotFoundException, SQLException;


}
