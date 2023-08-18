package app.persistence;

import java.sql.SQLException;
import java.util.List;

import app.model.Order;
import app.model.OrderDetails;

public interface InterfaceOrderDao {
    public Order visualizeOrder(Order o) throws ClassNotFoundException, SQLException;

    public List<Order> visualizeAllOrders() throws ClassNotFoundException, SQLException;

    public Order insertOrder(Order o) throws ClassNotFoundException, SQLException;

    public OrderDetails insertOrderAddLastOrderDetails(Order o) throws ClassNotFoundException, SQLException;

    public List<Order> showProcedure() throws ClassNotFoundException, SQLException;
}
