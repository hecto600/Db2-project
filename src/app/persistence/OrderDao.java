package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import app.controller.InterfaceOrderController;
import app.model.Order;

public class OrderDao implements InterfaceOrderDao {
    private Connection c;

    public OrderDao() throws ClassNotFoundException, SQLException{
        GenericDao gDao = new GenericDao();
        c = gDao.getConnection();
    }

    @Override
    public Order visualizeOrder(Order o) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Order> visualizeAllOrders(Order o) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Order insertOrder(Order o) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Orders VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1,o.getOrderID());
        ps.setString(2,o.getCustomerID());
        ps.setInt(3,o.getEmployeeID());        
        ps.setTimestamp(4,o.getOrderDate());        
        ps.setTimestamp(5,o.getRequiredDate());
        ps.setTimestamp(6,o.getShippedDate());
        ps.setInt(7,o.getShipVia());
        ps.setBigDecimal(8,o.getFreight());
        ps.setString(9,o.getShipName());
        ps.setString(10,o.getShipAddress());
        ps.setString(11,o.getShipCity());
        ps.setString(12,o.getShipRegion());
        ps.setString(13,o.getShipPostalCode());
        ps.setString(14,o.getShipCountry());
        ps.execute();
        ps.close();
        return null;
    }
    
}
