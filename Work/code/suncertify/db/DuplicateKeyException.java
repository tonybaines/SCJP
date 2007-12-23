package suncertify.db;

/**
 * @version $Id$
 */
public class DuplicateKeyException extends Exception {

    private static final long serialVersionUID = -6689165809485807888L;

    /**
     * Create a new instance of DuplicateKeyException
     */
    public DuplicateKeyException() {
        super();
    }

    /**
     * Create a new instance of DuplicateKeyException
     * 
     * @param message
     */
    public DuplicateKeyException(String message) {
        super(message);
    }

}
