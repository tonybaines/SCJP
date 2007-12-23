/**
 * 
 */
package suncertify.db;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author tony
 * 
 */
public class DataFileHelper {

    private static final Logger LOG = Logger.getLogger(DataFileHelper.class
            .getName());

    private int startOfDataOffset;

    private short recordFieldsCount;

    private final List<SchemaEntry> schema = new ArrayList<SchemaEntry>();
    private final List<HotelBookingRecord> records = new ArrayList<HotelBookingRecord>();

    public synchronized final void parse(final File source) throws IOException {
        java.io.DataInputStream inputStream = new DataInputStream(
                new BufferedInputStream(new FileInputStream(source)));
        parseStartOfFile(inputStream);
        parseSchema(inputStream);
        parseRecords(inputStream);
    }

    private void parseStartOfFile(final DataInputStream inputStream)
            throws IOException {
        int cookie = inputStream.readInt();
        LOG.fine("'magic cookie' : " + cookie);
        this.startOfDataOffset = inputStream.readInt();
        this.recordFieldsCount = inputStream.readShort();
    }

    private void parseSchema(final DataInputStream inputStream)
            throws IOException {

        // Loop over all record schema entries
        for (int fieldNum = 0; fieldNum < getRecordFieldsCount(); fieldNum++) {
            short fieldNameLength = inputStream.readShort();

            String fieldName = readAsciiString(inputStream, fieldNameLength);

            short lengthOfField = inputStream.readShort();

            SchemaEntry entry = new SchemaEntry(fieldName.toString(),
                    lengthOfField);
            this.schema.add(entry);
            LOG.fine("Created schema entry: " + entry);

        }
    }

    /**
     * @param inputStream
     * @throws IOException
     */
    private void parseRecords(final DataInputStream inputStream)
            throws IOException {

        while (inputStream.available() > 0) {
            this.records.add(readRecord(inputStream));
        }
    }

    /**
     * @param inputStream
     * @throws IOException
     */
    private HotelBookingRecord readRecord(final DataInputStream inputStream)
            throws IOException {
        boolean deleted = (inputStream.readShort() == 0x8000);
        LOG.info("Is this a deleted record?: " + deleted);

        HotelBookingRecord retVal = null;
        try {
            Map<String, String> recordMap = new HashMap<String, String>();
            for (Iterator<SchemaEntry> iterator = this.schema.iterator(); iterator
                    .hasNext();) {
                SchemaEntry schemaEntry = iterator.next();
                String fieldValue = readAsciiString(inputStream, schemaEntry
                        .getLengthOfField());
                recordMap.put(schemaEntry.getFieldName(), fieldValue.trim());
            }
            LOG.fine("Map is " + recordMap);
            retVal = HotelBookingRecord.buildFromMap(recordMap);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }

        LOG.info("Record is " + retVal);
        return retVal;
    }

    /**
     * @param inputStream
     * @param length
     * @return
     * @throws IOException
     */
    private String readAsciiString(final DataInputStream inputStream,
            short length) throws IOException {
        // Build the name of the field
        StringBuffer stringValue = new StringBuffer();
        for (short i = 0; i < length; i++) {
            // Need to parse one byte at a time -
            // the readChar() method expects a 16-bit UTF char
            // but the database uses 8-bit ASCII
            stringValue.append((char) inputStream.readByte());
        }
        return stringValue.toString();
    }

    public final short getRecordFieldsCount() {
        return this.recordFieldsCount;
    }

    public final int getStartOfDataOffset() {
        return this.startOfDataOffset;
    }

    public final int getRecordCount() {
        return this.records.size();
    }

    public final List<HotelBookingRecord> getRecords() {
        return Collections.unmodifiableList(this.records);
    }

    /**
     * @return the schema
     */
    public final List<SchemaEntry> getSchema() {
        return Collections.unmodifiableList(this.schema);
    }

}
