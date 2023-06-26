package lk.ijse.Jayasakuna.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    //Encapculation Usage
    private static DBconnection dbConnection;
    private Connection con;

    private DBconnection() throws SQLException {
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ Jayasakuna",
                "root",
                "Dilshan@2005"
        );
    }

    public static DBconnection getInstance() throws SQLException {

        return (null == dbConnection) ? dbConnection = new DBconnection()
                : dbConnection;
    }
    public Connection getConnection() {
        return con;
    }
}
