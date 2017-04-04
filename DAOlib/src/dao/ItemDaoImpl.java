package dao;

import Dictionary.Item;
import Dictionary.Meaning;
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
final class ItemDaoImpl extends AbstractDao<Item> implements ItemDao {

    private final String insSql = "INSERT INTO ITEM (NAME, DATE, AUTHOR) VALUES (?, ?, ?)";
    private final String updSql = "UPDATE ITEM SET (NAME, DATE, AUTHOR) VALUES (?, ?, ?) WHERE ID = ?";
    private final String delSql = "DELETE FROM ITEM WHERE ID = ?";
    private final String FindIdSql = "SELECT * FROM ITEM WHERE ID = ?";
    private final String FindNameSql = "SELECT * FROM ITEM WHERE NAME = ?";
    private final String getListSql = "SELECT * FROM ITEM, MEANING WHERE ITEM.ID = MEANING.ITEM_ID ORDER BY ITEM.ID";
    private PreparedStatement insSt, updSt, delSt, findIdSt, findNameSt, getListSt;
    private final MeaningDaoImpl mDao;

    public ItemDaoImpl(Connection connection) {
        super(connection);
        mDao = new MeaningDaoImpl(connection);

    }

    @Override
    public synchronized void create(Item item) throws SQLException {
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
    public synchronized void update(Item item) throws SQLException {
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

    @Override
    public List<Item> getList() throws SQLException {
        if (getListSt == null) {
            getListSt = c.prepareStatement(getListSql);
        }
        
        LinkedList<Item> list = new LinkedList<>();
        
        ResultSet rs = getListSt.executeQuery();
        while (rs.next()) {
            Item item = create(rs);
            if (item.getId() == list.getLast().getId()) {
                list.getLast().addMeaning(mDao.create(rs));
                continue;
            }
            item.addMeaning(mDao.create(rs));
            list.add(item);
        }
        
        return list;
    }

    @Override
    public Item findById(int id) throws SQLException {
        if (findIdSt == null) {
            findIdSt = c.prepareStatement(FindIdSql);
        }

        ResultSet rs = findIdSt.executeQuery();
        if (!rs.next()) return null;
        Item item = create(rs);
        item.setMeaning(getMeaning(rs.getInt("ID")));
        return item;
    }

    @Override
    public Item findByName(String itemName) throws SQLException {
        if (findNameSt == null) {
            findNameSt = c.prepareStatement(FindNameSql);
        }

        ResultSet rs = findIdSt.executeQuery();
        if (!rs.next()) return null;
        Item item = create(rs);
        item.setMeaning(getMeaning(rs.getInt("ID")));
        return item;

    }

    @Override
    public synchronized void delete(int id) throws SQLException {
        if (delSt == null) {
            delSt = c.prepareStatement(delSql);
        }
        delSt.setInt(1, id);
        if (delSt.execute()) {
            System.out.println("Item id= " + id + " deleted");
        }
    }
    
    private synchronized LinkedList<Meaning> getMeaning(int id) throws SQLException{
        return mDao.findByItemId(id);
    }
    
    private synchronized Item create(ResultSet rs) throws SQLException {
        return new Item(rs.getInt("ITEM.ID"),
                rs.getString("ITEM.NAME"),
                rs.getDate("ITEM.DATE"),
                rs.getString("ITEM.AUTHOR"));
    }

    @Override
    public void clearStatements() throws SQLException{
        insSt.close();
        updSt.close();
        delSt.close();
        findIdSt.close();
        findNameSt.close();
        getListSt.close();
        insSt = updSt = delSt = findIdSt = findNameSt = getListSt = null;
    }
    
    
    
}
