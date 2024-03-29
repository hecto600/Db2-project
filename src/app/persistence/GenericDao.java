package app.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {
    private Connection con;

    public Connection getConnection() throws ClassNotFoundException, SQLException{
        String hostname = "DESKTOP-CQHO7Q7/Northwind";
        String dbName = "Northwind";
        String user = "DESKTOP-CQHO7Q7";
        String pw = "";

        Class.forName("net.sourceforge.jtds.jdbc.Driver");

        con = DriverManager.getConnection(
            String.format("jdbc:jtds:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s",
             hostname, dbName, user, pw) );
        return con;
    }   

}
