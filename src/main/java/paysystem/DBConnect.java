package paysystem;

import java.sql.*;

public class DBConnect {
    private static final String URL = "jdbc:postgresql://localhost:5432/your-db-name";
    private static final String USER = "your-username";
    private static final String PASSWORD = "your-password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

