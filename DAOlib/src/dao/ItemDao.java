package dao;

import Dictionary.Item;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author kirill
 */
class ItemDao extends AbstractDao<Item> {

    private final String insSql = "INSERT INTO ITEM (NAME, DATE, AUTHOR) VALUES (?, ?, ?)";
    private final String updSql = "UPDATE ITEM SET (NAME, DATE, AUTHOR) VALUES (?, ?, ?) WHERE ID = ?";
    private final String delSql = "DELETE FROM ITEM WHERE ID = ?";
    private final String FindIdSql = "SELECT * FROM ITEM WHERE ID = ?";
    private final String FindNameSql = "SELECT * FROM ITEM WHERE NAME = ?";
    private final String getListSql = "SELECT ID, NAME FROM ITEM";
    private PreparedStatement insSt, updSt, delSt, findIdSt, findNameSt, getListSt;
    private MeaningDao mDao;

    public ItemDao(Connection connection) {
        super(connection);
        mDao = new MeaningDao(connection);

    }

    @Override
    public void create(Item item) throws SQLException {
        if (insSt == null) {
            insSt = c.prepareStatement(insSql);
        }
        insSt.setString(1, item.getItemName());
        insSt.setDate(2, new Date(System.currentTimeMillis()));
        insSt.setString(3, item.getAuthorName());
        if (insSt.execute()) {
            System.out.println("Item " + item.getItemName() + " created by " + item.getAuthorName());
        }
    }

    @Override
    public void update(Item item) throws SQLException {
        if (updSt == null) {
            updSt = c.prepareStatement(updSql);
        }
        updSt.setString(1, item.getItemName());
        updSt.setDate(2, new Date(System.currentTimeMillis()));
        updSt.setString(3, item.getAuthorName());
        updSt.setInt(4, item.getId());
        if (updSt.execute()) {
            System.out.println("Item id = " + item.getId() + " updated by" + item.getAuthorName());
        }
    }

    public List<Item> getList() throws SQLException {
        if (getListSt == null) {
            getListSt = c.prepareStatement(getListSql);
        }

        ResultSet rs = getListSt.executeQuery();
        LinkedList<Item> list = new LinkedList<>();
        while (rs.next()) {
            list.add(new Item(rs.getInt("ID"), rs.getString("NAME")));
        }
        return list;
    }

    @Override
    public Item findById(int id) throws SQLException {
        if (findIdSt == null) {
            findIdSt = c.prepareStatement(FindIdSql);
        }

        ResultSet rs = findIdSt.executeQuery();
        return new Item(rs.getInt("ID"), rs.getString("NAME"), rs.getDate("DATE"), rs.getString("AUTHOR"));
    }

    public Item findByName(String itemName) throws SQLException {
        if (findNameSt == null) {
            findNameSt = c.prepareStatement(FindNameSql);
        }

        ResultSet rs = findIdSt.executeQuery();
        return new Item(rs.getInt("ID"), rs.getString("NAME"), rs.getDate("DATE"), rs.getString("AUTHOR"));

    }

    @Override
    public void delete(int id) throws SQLException {
        if (delSt == null) {
            delSt = c.prepareStatement(delSql);
        }
        delSt.setInt(1, id);
        if (delSt.execute()) {
            System.out.println("Item id= " + id + " deleted");
        }
    }

}
