package Shopkeeper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnections {
    public static Connection createDBConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/shopkeeper?useSSL=false";
            String username = "root";
            String password = "root";

            con = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established successfully!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }

        return con;
    }
}

