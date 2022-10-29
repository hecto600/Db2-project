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
        ps.setInt(1, o.getOrderID());

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
        String sql = "BEGIN TRANSACTION;" +
                "INSERT INTO Orders " +
                "(CustomerID, EmployeeID, OrderDate, RequiredDate," +
                "ShippedDate, ShipVia, Freight, ShipName, " +
                "ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry) " +
                "VALUES(" +
                "(SELECT c.CustomerID FROM Customers AS c WHERE c.CustomerID = 'ALFKI'), " +
                "(SELECT e.EmployeeID FROM Employees AS e WHERE e.EmployeeID = 1), " +
                "CURRENT_TIMESTAMP, " +
                "DATEADD(DAY, 3, CURRENT_TIMESTAMP), " +
                "NULL, " +
                "(SELECT s.ShipperID FROM Shippers AS s WHERE s.ShipperID = 1), " +
                "?, " +
                "?, " +
                "?, " +
                "?, " +
                "?, " +
                "?, " +
                "? " +
                "); " +
                "INSERT INTO [Order Details] (OrderID, ProductID, UnitPrice, Quantity, Discount) " +
                "VALUES(" +
                "(SELECT IDENT_CURRENT('Orders')), " +
                "?, " +
                "?, " +
                "?, " +
                "? " +
                ");" +
                "COMMIT;";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setBigDecimal(1, o.getFreight());
        ps.setString(2, o.getShipName());
        ps.setString(3, o.getShipAddress());
        ps.setString(4, o.getShipCity());
        ps.setString(5, o.getShipRegion());
        ps.setString(6, o.getShipPostalCode());
        ps.setString(7, o.getShipCountry());
        ps.setInt(8, o.getOd().getProductID());
        ps.setBigDecimal(9, o.getOd().getUnitPrice());
        ps.setShort(10, o.getOd().getQuantity());
        ps.setFloat(11, o.getOd().getDiscount());
        ps.execute();
        ps.close();

        String sql2 = "SELECT IDENT_CURRENT('Orders') as OrderID";
        PreparedStatement ps2 = c.prepareStatement(sql2);
        ResultSet rs = ps2.executeQuery();
        if (rs.next()) {
            o.setOrderID(rs.getInt("OrderID"));
        }
        return visualizeOrder(o);
    }

}
