package suncertify.db;

/**
 * 
 */
public class Records {

    private static final int RECORD_NUMBER = 0;
    private static final int NAME = 1;
    private static final int CITY = 2;
    private static final int MAX_OCCUPANCY = 3;
    private static final int SMOKING_ALLOWED = 4;
    private static final int PRICE_PER_NIGHT = 5;
    private static final int DATE_AVAILABLE = 6;
    private static final int RECORD_OWNER_ID = 7;
    private static final int IS_DELETED = 8;

    /**
     * @param strings
     * @return
     */
    public static boolean isDeleted(String[] record) {
        return Boolean.valueOf(record[IS_DELETED]);
    }

    public static String toString(String[] record) {
        StringBuffer buf = new StringBuffer("[");
        buf.append("Rec No.=" + record[Records.RECORD_NUMBER]);
        final String separator = ", ";
        buf.append(separator);
        buf.append("Name=" + record[Records.NAME]);
        buf.append(separator);
        buf.append("City=" + record[CITY]);
        buf.append(separator);
        buf.append("Max. persons=" + record[MAX_OCCUPANCY]);
        buf.append(separator);
        buf.append("Smoking allowed?="
                + Boolean.valueOf(record[SMOKING_ALLOWED]));
        buf.append(separator);
        buf.append("Cost=" + record[PRICE_PER_NIGHT]);
        buf.append(separator);
        buf.append("Date available=" + record[DATE_AVAILABLE]);
        buf.append(separator);
        buf.append("Owning Customer ID=" + record[RECORD_OWNER_ID]);
        buf.append(separator);
        buf.append("Deleted?.=" + Boolean.valueOf(record[IS_DELETED]));
        buf.append("]");

        return buf.toString();
    }

    /**
     * @param record
     * @return
     */
    public static String getName(String[] record) {
        return record[NAME];
    }

    /**
     * @param record
     * @return
     */
    public static String getLocation(String[] record) {
        return record[CITY];
    }

}
