package suncertify.db;

/**
 * 
 * @version $Id$
 */
public class RecordNotFoundException extends Exception {

    private static final long serialVersionUID = 9172845648588845215L;

    /**
     * Create a new instance of RecordNotFoundException
     */
    public RecordNotFoundException() {
        super();
    }

    /**
     * Create a new instance of RecordNotFoundException
     * 
     * @param message
     */
    public RecordNotFoundException(String message) {
        super(message);
    }
}
