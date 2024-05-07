import entities.User;
import orm.EntityManager;
import orm.MyConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import static orm.MyConnector.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException {
        MyConnector.createConnection("test", "aassdd", "custom-orm");
        Connection connection = getConnection();

        EntityManager<User> userEntityManager = new EntityManager<>(connection);

        User user = new User("Pesho", 25, LocalDate.now());

        //userEntityManager.doCreate(User.class);
        userEntityManager.doAlter(User.class);
        userEntityManager.persist(user);
    }
}
