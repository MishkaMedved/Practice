package ru.mixail.app;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectBD {

    private static final String URL = "jdbc:postgresql://localhost:5432/practice";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}
