package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.model.Order;

public class OrderDao implements InterfaceOrderDao {
    private Connection c;

    public OrderDao() throws ClassNotFoundException, SQLException {
        GenericDao gDao = new GenericDao();
        c = gDao.getConnection();
    }

    @Override
    public Order visualizeOrder(Order o) throws ClassNotFoundException, SQLException {
        String sql = "SELECT " +
                "OrderID, " +
                "CustomerID, " +
                "EmployeeID, " +
                "OrderDate, " +
                "RequiredDate, " +
                "ShippedDate, " +
                "ShipVia, " +
                "Freight, " +
                "ShipName, " +
                "ShipAddress, " +
                "ShipCity, " +
                "ShipRegion, " +
                "ShipPostalCode, " +
                "ShipCountry " +
                "FROM ORDERS " +
                "WHERE OrderID = (?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, o.getCustomerID());

        ResultSet rs = ps.executeQuery();
        int count = 0;
        if (rs.next()) {
            o.setOrderID(rs.getInt("OrderID"));
            o.setCustomerID(rs.getString("CustomerID"));
            o.setEmployeeID(rs.getInt("EmployeeID"));
            o.setOrderDate(rs.getTimestamp("OrderDate"));
            o.setRequiredDate(rs.getTimestamp("RequiredDate"));
            o.setShippedDate(rs.getTimestamp("ShippedDate"));
            o.setShipVia(rs.getInt("ShipVia"));
            o.setFreight(rs.getBigDecimal("Freight"));
            o.setShipName(rs.getString("ShipName"));
            o.setShipAddress(rs.getString("ShipAddress"));
            o.setShipCity(rs.getString("ShipCity"));
            o.setShipRegion(rs.getString("ShipRegion"));
            o.setShipPostalCode(rs.getString("ShipPostalCode"));
            o.setShipCountry(rs.getString("ShipCountry"));
            count++;
        }
        if (count == 0)
          return null;
          
        rs.close();
        ps.close();
        return o;
    }

    @Override
    public List<Order> visualizeAllOrders() throws ClassNotFoundException, SQLException {
        String sql = "SELECT " +
        "OrderID, " +
        "CustomerID, " +
        "EmployeeID, " +
        "OrderDate, " +
        "RequiredDate, " +
        "ShippedDate, " +
        "ShipVia, " +
        "Freight, " +
        "ShipName, " +
        "ShipAddress, " +
        "ShipCity, " +
        "ShipRegion, " +
        "ShipPostalCode, " +
        "ShipCountry " +
        "FROM ORDERS";
                    
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Order> orderList = new ArrayList<Order>();
        while (rs.next()) {
            Order o = new Order();
            o.setOrderID(rs.getInt("OrderID"));
            o.setCustomerID(rs.getString("CustomerID"));
            o.setEmployeeID(rs.getInt("EmployeeID"));
            o.setOrderDate(rs.getTimestamp("OrderDate"));
            o.setRequiredDate(rs.getTimestamp("RequiredDate"));
            o.setShippedDate(rs.getTimestamp("ShippedDate"));
            o.setShipVia(rs.getInt("ShipVia"));
            o.setFreight(rs.getBigDecimal("Freight"));
            o.setShipName(rs.getString("ShipName"));
            o.setShipAddress(rs.getString("ShipAddress"));
            o.setShipCity(rs.getString("ShipCity"));
            o.setShipRegion(rs.getString("ShipRegion"));
            o.setShipPostalCode(rs.getString("ShipPostalCode"));
            o.setShipCountry(rs.getString("ShipCountry"));

            orderList.add(o);
        }
        rs.close();
        ps.close();
        return orderList;
    }

    @Override
    public Order insertOrder(Order o) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Orders VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, o.getOrderID());
        ps.setString(2, o.getCustomerID());
        ps.setInt(3, o.getEmployeeID());
        ps.setTimestamp(4, o.getOrderDate());
        ps.setTimestamp(5, o.getRequiredDate());
        ps.setTimestamp(6, o.getShippedDate());
        ps.setInt(7, o.getShipVia());
        ps.setBigDecimal(8, o.getFreight());
        ps.setString(9, o.getShipName());
        ps.setString(10, o.getShipAddress());
        ps.setString(11, o.getShipCity());
        ps.setString(12, o.getShipRegion());
        ps.setString(13, o.getShipPostalCode());
        ps.setString(14, o.getShipCountry());
        ps.execute();
        ps.close();
        return visualizeOrder(o);
    }

}
