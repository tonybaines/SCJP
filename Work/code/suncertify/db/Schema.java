package suncertify.db;

/**
 * 
 */
public interface Schema {
    public static final int RECORD_NUMBER = 0;
    public static final int NAME = 1;
    public static final int CITY = 2;
    public static final int MAX_OCCUPANCY = 3;
    public static final int SMOKING_ALLOWED = 4;
    public static final int PRICE_PER_NIGHT = 5;
    public static final int DATE_AVAILABLE = 6;
    public static final int RECORD_OWNER_ID = 7;
    public static final int IS_DELETED = 8;
    /** The number of fields in a record */
    public static final int NUM_FIELDS = 9;
}
