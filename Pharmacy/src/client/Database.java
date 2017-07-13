package client;

import java.sql.*;
import oracle.jdbc.OracleDriver;

public class Database {
    public Database() {
        super();
    }
    /* method return a connection to the database 
     * use to open a connection with the database
     */
    public static Connection getConnection() throws SQLException {
        String username = "pharmacy";
        String password = "master";
        String thinConn = "jdbc:oracle:thin:@localhost:1521:XE";
        DriverManager.registerDriver(new OracleDriver());
        Connection conn =
            DriverManager.getConnection(thinConn, username, password);
        conn.setAutoCommit(false);
        return conn;
    }
}
