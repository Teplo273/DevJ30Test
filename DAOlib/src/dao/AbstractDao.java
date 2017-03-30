package dao;

import Dictionary.AbstractEntity;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author kirill
 */
public abstract class AbstractDao<E extends AbstractEntity> {

    protected final Connection c;

    public AbstractDao(Connection connection) {
        this.c = connection;
    }

    public abstract void create(E item) throws SQLException;

    public abstract void update(E item) throws SQLException;

    public abstract void delete(int id) throws SQLException;

    public abstract E findById(int id) throws SQLException;

}
