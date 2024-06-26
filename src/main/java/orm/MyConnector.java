package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnector {
    private static Connection connection;
    //private static final String connectionString = "jdbc:mysql://192.168.5.200:3306/"; //local
    private static final String connectionString = "jdbc:mysql://78.90.227.249:3306/"; //external

    //private MyConnector() {}

    public static void createConnection(String user, String password, String dbName) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        connection = DriverManager.getConnection(connectionString + dbName, properties);
    }

    public static Connection getConnection() {
        return connection;
    }
}
