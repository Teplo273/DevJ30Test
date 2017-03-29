package dao;

import Dictionary.AbstractEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import sql.query.queryGenerators.QueryGenerator;

/**
 *
 * @author kirill
 */
public abstract class AbstractDao<E extends AbstractEntity> {

    protected final Connection c;
    protected PreparedStatement ps;
    protected final QueryGenerator g;

    public AbstractDao(Connection connection) {
        this.c = connection;
        this.g = QueryGenerator.getGenerator();
    }

    public abstract void create(E item) throws SQLException;

    public abstract void update(E item) throws SQLException;

    public abstract void delete(int id) throws SQLException;

    public abstract E findById(int id) throws SQLException;

}
