package app.controller;

import java.sql.SQLException;

import app.model.Order;

public interface InterfaceOrderController {
    public void visualizeOrder(Order o) throws ClassNotFoundException, SQLException;
    public void visualizeAllOrders() throws ClassNotFoundException, SQLException;
    public Order insertOrder(Order o) throws ClassNotFoundException, SQLException;

}
