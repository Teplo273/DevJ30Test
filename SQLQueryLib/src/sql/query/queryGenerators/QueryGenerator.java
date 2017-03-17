/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql.query.queryGenerators;

import sql.query.exceptions.WrongNumberOfArgumentException;

/**
 *
 * @author kirill
 */
public interface QueryGenerator {

    String getDelete(String table, String condition);

    /**
     *
     * @param user
     * @param table
     * @param args contains columns & values with next order {column1, column2,
     * ... columnN, value1, value2, ... valueN}
     * @return
     * @throws sql.query.exceptions.WrongNumberOfArgumentException
     */
    String getInsert(String user, String table, String... args) throws WrongNumberOfArgumentException;

    /**
     *
     * @param table
     * @param args contains columns & values with next order {column1, column2,
     * ... columnN, value1, value2, ... valueN}
     * @return
     * @throws WrongNumberOfArgumentException
     */
    String getInsert(String table, String... args) throws WrongNumberOfArgumentException;

    String getSelect(String table, String condition, String... fields);

    /**
     *
     * @param table
     * @param condition
     * @param args contains columns & values with next order {column1, column2,
     * ... columnN, value1, value2, ... valueN}
     * @return
     * @throws WrongNumberOfArgumentException
     */
    String getUpdate(String table, String condition, String... args) throws WrongNumberOfArgumentException;

    public static QueryGenerator getGenerator() {
        return new JavadbQueryImpl();
    }

}
