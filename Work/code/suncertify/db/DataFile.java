package suncertify.db;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * 
 */
public class DataFile {

    /**
     * Magic number flag for a deleted record
     */
    private static final int DELETED_RECORD_FLAG = 0x8000;

    private static final Logger LOG = Logger
            .getLogger(DataFile.class.getName());

    private int startOfDataOffset;

    private short recordFieldsCount;

    private final List<SchemaEntry> schema = new ArrayList<SchemaEntry>();
    private final List<String[]> records = new ArrayList<String[]>();

    public DataFile(final File source) {

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

    public final List<String[]> getRecords() {
        return Collections.unmodifiableList(this.records);
    }

    public final List<SchemaEntry> getSchema() {
        return Collections.unmodifiableList(this.schema);
    }

    private void parse(final File source) throws IOException {
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

            String fieldName = readAsciiString(inputStream, fieldNameLength)
                    .trim();

            short lengthOfField = inputStream.readShort();

            this.schema.add(new SchemaEntry(fieldName, lengthOfField));
            LOG.fine("Created schema entry: "
                    + this.schema.get(this.schema.size() - 1));

        }
    }

    /**
     * @param inputStream
     * @throws IOException
     */
    private void parseRecords(final DataInputStream inputStream)
            throws IOException {
        int recordNum = 0;
        while (inputStream.available() > 0) {
            this.records.add(readRecord(inputStream, recordNum));
            recordNum++;
        }
    }

    /**
     * @param inputStream
     * @param recordNum
     * @throws IOException
     */
    private String[] readRecord(final DataInputStream inputStream, int recordNum)
            throws IOException {
        boolean deleted = (inputStream.readShort() == DELETED_RECORD_FLAG);
        LOG.fine("Is this a deleted record?: " + deleted);

        List<String> record = new Vector<String>();
        record.add(Integer.toString(recordNum));
        for (Iterator<SchemaEntry> iterator = this.schema.iterator(); iterator
                .hasNext();) {
            SchemaEntry schemaEntry = iterator.next();
            String fieldValue = readAsciiString(inputStream,
                    schemaEntry.getLengthOfField()).trim();
            record.add(fieldValue);
        }
        record.add(Boolean.toString(deleted));
        LOG.fine("Record is " + record);

        return record.toArray(new String[] {});
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

}
