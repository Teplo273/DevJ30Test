package dao;

import Dictionary.Item;
import Dictionary.Meaning;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author kirill
 */
final class MeaningDaoImpl extends AbstractDao<Meaning> {

    private final String insSql = "INSERT INTO MEANING (TEXT, ITEM_ID, DATE, AUTHOR) VALUES (?, ?, ?, ?)";
    private final String updSql = "UPDATE MEANING SET (TEXT, DATE, AUTHOR) VALUES (?, ?, ?) WHERE ID = ?";
    private final String delSql = "DELETE FROM MEANING WHERE ID = ?";
    private final String FindIdSql = "SELECT * FROM MEANING WHERE ID = ?";
    private final String FindItemIdSql = "SELECT * FROM MEANING WHERE ITEM_ID = ?";
    private final String getAllSql = "SELECT * FROM MEANING";

    private PreparedStatement insSt, updSt, delSt, findIdSt, findItemIdSt, getAllSt;

    public MeaningDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Meaning meaning) throws SQLException {
        if (insSt == null) {
            insSt = c.prepareStatement(insSql);
        }
        insSt.setString(1, meaning.getValue());
        insSt.setInt(2, meaning.getId());
        insSt.setDate(3, new Date(System.currentTimeMillis()));
        insSt.setString(4, meaning.getAuthorName());
        if (insSt.execute()) {
            System.out.println("meaning of item id= "
                    + meaning.getItemId()
                    + " created by "
                    + meaning.getAuthorName());
        }
    }

    @Override
    public void update(Meaning meaning) throws SQLException {
        if (updSt == null) {
            updSt = c.prepareStatement(updSql);
        }
        updSt.setString(1, meaning.getValue());
        updSt.setDate(2, new Date(System.currentTimeMillis()));
        updSt.setString(3, meaning.getAuthorName());
        updSt.setInt(4, meaning.getId());
        if (updSt.execute()) {
            System.out.println("meaning of item id = " + meaning.getItemId() + " updated by" + meaning.getAuthorName());
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        if (delSt == null) {
            delSt = c.prepareStatement(delSql);
        }
        delSt.setInt(1, id);
        if (delSt.execute()) {
            System.out.println("meaning id= " + id + " deleted");
        }
    }

    @Override
    public Meaning findById(int id) throws SQLException {
        if (findIdSt == null) {
            findIdSt = c.prepareStatement(FindIdSql);
        }

        findIdSt.setInt(1, id);
        ResultSet rs = findIdSt.executeQuery();
        return (!rs.next()) ? null : create(rs);
    }

    public LinkedList<Meaning> findByItemId(int itemId) throws SQLException {
        if (findItemIdSt == null) {
            findItemIdSt = c.prepareStatement(FindItemIdSql);
        }
        findItemIdSt.setInt(1, itemId);
        LinkedList list = new LinkedList();
        ResultSet rs = findItemIdSt.executeQuery();

        while (rs.next()) {
            list.add(create(rs));
        }
        return list.size() != 0 ? list : null;
    }

    public LinkedList<Meaning> getAll() throws SQLException {
        if (getAllSt == null) {
            getAllSt = c.prepareStatement(getAllSql);
        }
        LinkedList list = new LinkedList();
        ResultSet rs = getAllSt.executeQuery();

        while (rs.next()) {
            list.add(create(rs));
        }
        return list.size() != 0 ? list : null;

    }

    Meaning create(ResultSet rs) throws SQLException {
        return new Meaning(rs.getInt("MEANING.ID"),
                rs.getString("MEANING.NAME"),
                rs.getDate("MEANING.DATE"),
                rs.getString("MEANING.AUTHOR"),
                rs.getInt("MEANING.ITEM_ID"));
    }

}
