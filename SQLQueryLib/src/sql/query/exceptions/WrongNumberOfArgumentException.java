package sql.query.exceptions;

/**
 *
 * @author kirill
 */
public class WrongNumberOfArgumentException extends Exception {

    public WrongNumberOfArgumentException() {
    }

    public WrongNumberOfArgumentException(String msg) {
        super(msg);
    }
}
