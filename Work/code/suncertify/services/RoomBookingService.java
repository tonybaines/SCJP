package suncertify.services;

import java.util.*;

import suncertify.db.*;

/**
 * 
 */
public class RoomBookingService {

    private final DBMain data;

    /**
     * Create a new <code>RoomBookingService</code>
     * 
     * @param data
     *                The DBMain instance to perform operations on the data
     */
    public RoomBookingService(final DBMain data) {
        this.data = data;
    }

    /**
     * @return All records from the database
     * @throws RecordNotFoundException
     *                 if no undeleted records were found
     */
    public String[][] findAll() throws RecordNotFoundException {
        return findMatchingRecords(null, null);
    }

    /**
     * @param recNo
     * @return The record with index <code>recNo</code>
     * @throws RecordNotFoundException
     *                 if no record was found at that index or it is marked as
     *                 deleted
     */
    public String[] getRecord(int recNo) throws RecordNotFoundException {
        return this.data.read(recNo);
    }

    /**
     * @param reNo
     * @return
     * @throws RecordNotFoundException
     * @throws NumberFormatException
     */
    public String[] getRecord(String recNo) throws NumberFormatException,
            RecordNotFoundException {
        return getRecord(Integer.parseInt(recNo));
    }

    /**
     * @param name
     *                The name to match. Match records where the name is
     *                <b>exactly</b> the same. A value of <code>null</code>
     *                matches any name
     * @param location
     *                The location to match. Match records where the location is
     *                <b>exactly</b> the same. A value of <code>null</code>
     *                matches any location
     * @return Any matching records
     * @throws RecordNotFoundException
     *                 if no matching undeleted records were found
     */
    public String[][] findMatchingRecords(String name, String location)
            throws RecordNotFoundException {

        List<String[]> records = new ArrayList<String[]>();
        int[] recordNumbers = this.data.find(new String[] { name, location,
                null, null, null, null, null });

        for (int i = 0; i < recordNumbers.length; i++) {
            final String[] record = getRecord(recordNumbers[i]);

            boolean isExactNameMatch = (null == name)
                    || (name.equals(Records.getName(record)));
            boolean isExactLocationMatch = (null == location)
                    || (location.equals(Records.getLocation(record)));

            if (isExactNameMatch && isExactLocationMatch) {
                records.add(record);
            }
        }

        return records.toArray(new String[][] {});
    }
}
