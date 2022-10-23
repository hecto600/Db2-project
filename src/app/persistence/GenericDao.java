package app.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {
    private Connection con;

    public Connection getConnection() throws ClassNotFoundException, SQLException{
        String hostname = "localhost";
        String dbName = "TODO";
        String user = "TODO";
        String pw = "TODO";

        Class.forName("net.sourceforge.jtds.jdbc.Driver");

        con = DriverManager.getConnection(
            String.format("jdbc:jtds:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s",
             hostname, dbName, user, pw) );
        return con;
    }   

}
