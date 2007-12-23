/**
 * 
 */
package suncertify.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author tony
 * 
 */
public class HotelBookingRecord {
    private final String name;
    private final String city;
    private final short maxOccupancy;
    private final boolean smokingAllowed;
    private final Float pricePerNight;
    private final Date dateAvailable;
    private final String recordOwnerId;

    /**
     * @throws ParseException
     * @throws NumberFormatException
     * 
     */
    public static HotelBookingRecord buildFromMap(
            final Map<String, String> fieldsMap) throws NumberFormatException,
            ParseException {

        String name = fieldsMap.get("name");
        String location = fieldsMap.get("location");
        short size = Short.parseShort(fieldsMap.get("size"));
        boolean smoking = "Y".equals(fieldsMap.get("smoking"));
        float rate = Float.parseFloat(fieldsMap.get("rate").replaceFirst("\\$",
                ""));
        Date date = new SimpleDateFormat("yyyy/MM/dd").parse(fieldsMap
                .get("date"));
        String owner = fieldsMap.get("owner");
        if (owner == null)
            owner = "";

        return new HotelBookingRecord(name, location, size, smoking, rate,
                date, owner);
    }

    /**
     * 
     * @param fieldsMap
     * @param name
     * @return
     */
    private static String getString(final Map<String, String> fieldsMap,
            final String name) {
        String value = fieldsMap.get(name);
        return value;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * @return the maxOccupancy
     */
    public short getMaxOccupancy() {
        return this.maxOccupancy;
    }

    /**
     * @return the smokingAllowed
     */
    public boolean isSmokingAllowed() {
        return this.smokingAllowed;
    }

    /**
     * @return the pricePerNight
     */
    public float getPricePerNight() {
        return this.pricePerNight;
    }

    /**
     * @return the dateAvailable
     */
    public Date getDateAvailable() {
        return this.dateAvailable;
    }

    /**
     * @return the recordOwnerId
     */
    public String getRecordOwnerId() {
        return this.recordOwnerId;
    }

    public boolean isAvailable() {
        return getRecordOwnerId() == "";
    }

    /**
     * @param name
     * @param city
     * @param maxOccupancy
     * @param smokingAllowed
     * @param pricePerNight
     * @param dateAvailable
     * @param recordOwnerId
     */
    public HotelBookingRecord(String name, String city, short maxOccupancy,
            boolean smokingAllowed, float pricePerNight, Date dateAvailable,
            String recordOwnerId) {
        super();
        this.name = name;
        this.city = city;
        this.maxOccupancy = maxOccupancy;
        this.smokingAllowed = smokingAllowed;
        this.pricePerNight = pricePerNight;
        this.dateAvailable = dateAvailable;
        this.recordOwnerId = recordOwnerId;
    }

    /**
     * Constructs a <code>String</code> with all attributes in name = value
     * format.
     * 
     * @return a <code>String</code> representation of this object.
     */
    @Override
    public String toString() {
        final String TAB = ", ";

        StringBuffer retValue = new StringBuffer();

        retValue.append("HotelBookingRecord (").append(super.toString())
                .append(TAB).append("name=").append(this.name).append(TAB)
                .append("city=").append(this.city).append(TAB).append(
                        "maxOccupancy = ").append(this.maxOccupancy)
                .append(TAB).append("smokingAllowed=").append(
                        this.smokingAllowed).append(TAB).append(
                        "pricePerNight=").append(this.pricePerNight)
                .append(TAB).append("dateAvailable=")
                .append(this.dateAvailable).append(TAB)
                .append("recordOwnerId=").append(this.recordOwnerId)
                .append(TAB).append("available=").append(isAvailable()).append(
                        ")");

        return retValue.toString();
    }
}
