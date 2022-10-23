package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.model.Customer;

public class CustomerDao  implements InteraceCustomerDao{
    private Connection con;

    public CustomerDao() throws ClassNotFoundException, SQLException{
        GenericDao gDao =  new GenericDao();
        con = gDao.getConnection();
    }

    @Override
    public List<Customer> visualizeAllCustomer() throws SQLException {
         String sql =   "SELECT "           +
                        "CustomerID, "      +
                        "CompanyName, "     +
                        "ContactName, "     +
                        "Adress, "          +
                        "City, "            +
                        "Region, "          +
                        "PostalCode, "      +
                        "Country, "         +
                        "Phone, "           +
                        "Fax "              +
                        "FROM Customers "   ;
                        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();

        List<Customer> customerList = new ArrayList<Customer>();
        while (rs.next()) {
            Customer c = new Customer();
            c.setCustomerID(rs.getString("CustomerID"));
            c.setCompanyName(rs.getString("CompanyName"));
            c.setContactName(rs.getString("ContactName"));
            c.setAddres(rs.getString("Adress"));
            c.setCity(rs.getString("City"));
            c.setRegion(rs.getString("Region"));
            c.setPostalCode(rs.getString("PostalCode"));
            c.setCountry(rs.getString("Country"));
            c.setPhone(rs.getString("Phone"));
            c.setFax(rs.getString("Fax"));

            customerList.add(c);
        }
            rs.close();
            ps.close();
        return customerList;
    }

    @Override
    public Customer visualizeCustomer(Customer c) throws SQLException {
        String sql =    "SELECT "           +
                        "CustomerID, "      +
                        "CompanyName, "     +
                        "ContactName, "     +
                        "Adress, "          +
                        "City, "            +
                        "Region, "          +
                        "PostalCode, "      +
                        "Country, "         +
                        "Phone, "           +
                        "Fax "              +
                        "FROM Customers "   +
                        "WHERE CustomerID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, c.getCustomerID());   
        
        ResultSet rs = ps.executeQuery();
        int count = 0;
        if(rs.next()){
            c.setCustomerID(rs.getString("CustomerID"));
            c.setCompanyName(rs.getString("CompanyName"));
            c.setContactName(rs.getString("ContactName"));
            c.setAddres(rs.getString("Adress"));
            c.setCity(rs.getString("City"));
            c.setRegion(rs.getString("Region"));
            c.setPostalCode(rs.getString("PostalCode"));
            c.setCountry(rs.getString("Country"));
            c.setPhone(rs.getString("Phone"));
            c.setFax(rs.getString("Fax"));
            count++;
        }
        if (count == 0)
            c = new Customer();
        rs.close();
        
        return c;
    }

    @Override
    public void updateCustomer(Customer c) throws SQLException {
        String sql =    "UPDATE Customers SET " + 
                        "CompanyName = ?, "     + 
                        "ContactName = ?, "     +
                        "Adress = ?, "          +
                        "City = ?, "            +
                        "Region = ?, "          +
                        "PostalCode = ?, "      +
                        "Country = ?, "         +
                        "Phone = ?, "           +
                        "Fax = ?, "             +
                        "WHERE CustomerID = ? " ;
                        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, c.getCustomerID());            
        ps.setString(2, c.getCompanyName());            
        ps.setString(3, c.getContactName());        
        ps.setString(4, c.getContactTitle() );   
        ps.setString(5, c.getAddres());   
        ps.setString(6, c.getCity());   
        ps.setString(7, c.getRegion());   
        ps.setString(8, c.getPostalCode());   
        ps.setString(9, c.getCountry());   
        ps.setString(10, c.getPhone());
        ps.setString(11, c.getFax());       

        ps.execute();
        ps.close();
        
    }

    @Override
    public void insertCustomer(Customer c) throws SQLException {
        String sql =    "INSERT INTO "  +
                        "Customers VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, c.getCompanyName());            
        ps.setString(2, c.getContactName());        
        ps.setString(3, c.getContactTitle() );   
        ps.setString(4, c.getAddres());   
        ps.setString(5, c.getCity());   
        ps.setString(6, c.getRegion());   
        ps.setString(7, c.getPostalCode());   
        ps.setString(8, c.getCountry());   
        ps.setString(9, c.getPhone());
        ps.setString(10, c.getFax());       

        ps.execute();
        ps.close();
    }

    @Override
    public void removeCustomer(Customer c) throws SQLException {
        String sql = "DELETE Customers WHERE CustomerID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, c.getCustomerID());            

        ps.execute();
        ps.close();
        
    }
}
