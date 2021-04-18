package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/myDB";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);

            if (connection == null) System.out.println("null error");
        } catch (SQLException  throwables) {
            throwables.printStackTrace();
            System.out.println("Connection error");
        }


        return connection;
    }
}
