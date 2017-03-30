package dao;

import Dictionary.Item;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kirill
 */
public interface ItemDao {

    void create(Item item) throws SQLException;

    void update(Item item) throws SQLException;
    
    void delete(int id) throws SQLException;

    Item findById(int id) throws SQLException;

    Item findByName(String itemName) throws SQLException;

    List<Item> getList() throws SQLException;
    
}
