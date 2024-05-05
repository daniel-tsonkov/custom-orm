import entities.User;
import orm.EntityManager;
import orm.MyConnector;

import java.sql.Connection;
import java.sql.SQLException;

import static orm.MyConnector.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException {
        MyConnector.createConnection("test", "aassdd", "custom-orm");
        Connection connection = getConnection();

        EntityManager<User> userEntityManager = new EntityManager<>(connection);
    }
}
