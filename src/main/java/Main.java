import entities.User;
import orm.EntityManager;
import orm.MyConnector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static orm.MyConnector.createConnection;
import static orm.MyConnector.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        createConnection("test", "aassdd", "custom-orm");
        Connection connection = getConnection();

        EntityManager<User> userEntityManager = new EntityManager<>(connection);

        User user = new User("Pesho", 25, LocalDate.now());
        //user.setId(2);
        //user.setUsername("pesho_new_final");
        user.setUsername("pesho_new_finalv2");

        //userEntityManager.doCreate(User.class);
        //userEntityManager.doAlter(User.class);
        userEntityManager.persist(user);

        //User first = userEntityManager.findFirst(User.class, "id = 2");
        //System.out.println(first);
        //Iterable<User> first = userEntityManager.find(User.class, "id < 5");
        //System.out.println(first.toString());
        //Iterable<User> first = userEntityManager.find(User.class);
        //System.out.println(first.toString());

        userEntityManager.delete(user);
    }
}
