package orm;

import anotations.Id;

import java.lang.reflect.Field;
import java.sql.Connection;

public class EntityManager<E> implements DBContext<E> {
    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) {
        return false;
    }

    @Override
    public Iterable<E> find(Class<E> table) {
        return null;
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table, String where) {
        return null;
    }

    private Field getIdColumn(Class<E> clazz) {
        Field[] declareFields =  clazz.getDeclaredFields();
        for (Field declareField : declareFields) {
            boolean annotationPresent = declareField.isAnnotationPresent(Id.class);

            if (annotationPresent) {
                return declareField;
            }
        }

        throw new UnsupportedOperationException("Entity missing an Id column");
    }
}
