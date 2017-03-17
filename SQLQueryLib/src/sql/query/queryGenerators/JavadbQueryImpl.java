package sql.query.queryGenerators;

import sql.query.exceptions.WrongNumberOfArgumentException;

/**
 *
 * @author kirill
 */
class JavadbQueryImpl implements QueryGenerator {

    /**
     *
     * @param user
     * @param table
     * @param args contains columns & values with next order {column1, column2,
     * ... columnN, value1, value2, ... valueN}
     * @return
     * @throws sql.query.exceptions.WrongNumberOfArgumentException
     */
    @Override
    public String getInsert(String user, String table, String... args) throws WrongNumberOfArgumentException {

        int i = args.length;
        if (i % 2 != 0) {
            throw new WrongNumberOfArgumentException("Wrong number of args fo insert request.");
        }

        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();

        int j = 1;
        for (; j <= i / 2; j++) {
            columns.append(args[j - 1])
                    .append(", ");
        }
        for (; j <= i; j++) {
            values.append(args[j - 1])
                    .append(", ");
        }
        //delete last comma
        columns.deleteCharAt(columns.length() - 2);
        values.deleteCharAt(values.length() - 2);

        return new StringBuilder()
                .append("INSERT INTO ")
                .append(table)
                .append(" (")
                .append(columns.toString())
                .append(")")
                .append(" VALUE ").append(values.toString()).toString();
    }

    /**
     *
     * @param table
     * @param args contains columns & values with next order {column1, column2,
     * ... columnN, value1, value2, ... valueN}
     * @return
     * @throws WrongNumberOfArgumentException
     */
    @Override
    public String getInsert(String table, String... args) throws WrongNumberOfArgumentException {
        return this.getInsert(null, table, args);
    }

    @Override
    public String getSelect(String table, String condition, String... fields) {
        StringBuilder f = new StringBuilder();
        for (String field : fields) {
            f.append(field).append(", ");
        }
        f.deleteCharAt(fields.length - 2);

        return new StringBuilder()
                .append("SELECT ")
                .append(" FROM ")
                .append(f.toString())
                .append(table)
                .append(" WHERE ")
                .append(condition).toString();
    }

    /**
     *
     * @param table
     * @param condition
     * @param args contains columns & values with next order {column1, column2,
     * ... columnN, value1, value2, ... valueN}
     * @return
     * @throws WrongNumberOfArgumentException
     */
    @Override
    public String getUpdate(String table, String condition, String... args) throws WrongNumberOfArgumentException {
        if (args.length % 2 != 0) {
            throw new WrongNumberOfArgumentException("Wrong number of args fo insert request.");
        }
        int i = args.length / 2;

        StringBuilder f = new StringBuilder();
        for (int j = 0; j < i; j++) {
            f.append(args[j])
                    .append("=")
                    .append(args[j + i]);
        }

        return new StringBuilder()
                .append("UPDATE ")
                .append(table)
                .append(" SET ")
                .append(f.toString())
                .append(" WHERE ")
                .append(condition).toString();

    }

    @Override
    public String getDelete(String table, String condition) {
        return new StringBuilder()
                .append("DELETE FROM ")
                .append(table)
                .append(" WHERE ")
                .append(condition).toString();
    }

}
