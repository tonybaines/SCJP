package suncertify.db;

/**
 * Custom exception for
 * 
 * N.B. Defined as part of the Assignment. DO NOT CHANGE THE NAME OR PACKAGE
 * 
 * "Any unimplemented exceptions in this interface must all be created as member
 * classes of the suncertify.db package. Each must have a zero argument
 * constructor and a second constructor that takes a String that serves as the
 * exception's description.
 * 
 * Any methods that throw RecordNotFoundException should do so if a specified
 * record does not exist or is marked as deleted in the database file."
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
