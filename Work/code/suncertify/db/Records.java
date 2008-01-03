package suncertify.db;

/**
 * 
 */
public class Records {

    /**
     * @param strings
     * @return
     */
    public static boolean isDeleted(String[] record) {
        return Boolean.valueOf(record[Schema.IS_DELETED]);
    }

    public static String toString(String[] record) {
        StringBuffer buf = new StringBuffer("[");
        buf.append("Rec No.=" + record[Schema.RECORD_NUMBER]);
        final String separator = ", ";
        buf.append(separator);
        buf.append("Name=" + record[Schema.NAME]);
        buf.append(separator);
        buf.append("City=" + record[Schema.CITY]);
        buf.append(separator);
        buf.append("Max. persons=" + record[Schema.MAX_OCCUPANCY]);
        buf.append(separator);
        buf.append("Smoking allowed?="
                + Boolean.valueOf(record[Schema.SMOKING_ALLOWED]));
        buf.append(separator);
        buf.append("Cost=" + record[Schema.PRICE_PER_NIGHT]);
        buf.append(separator);
        buf.append("Date available=" + record[Schema.DATE_AVAILABLE]);
        buf.append(separator);
        buf.append("Owning Customer ID=" + record[Schema.RECORD_OWNER_ID]);
        buf.append(separator);
        buf.append("Deleted?.=" + Boolean.valueOf(record[Schema.IS_DELETED]));
        buf.append("]");

        return buf.toString();
    }

}
