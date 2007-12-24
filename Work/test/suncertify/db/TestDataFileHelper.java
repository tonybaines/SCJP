package suncertify.db;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;

public class TestDataFileHelper {

    private static final Logger LOG = Logger.getLogger(TestDataFileHelper.class
            .getName());

    @Test
    public void shouldReadMetaDataFromAValidStream() throws IOException {
        DataFileHelper helper = new DataFileHelper();
        helper.parse(new File("Work/db-1x2.db"));
        assertEquals(helper.getStartOfDataOffset(), 74);
        assertEquals(helper.getRecordFieldsCount(), 7);
        assertEquals(helper.getSchema().size(), 7);
        assertEquals(helper.getRecordCount(), 29);
        assertEquals(helper.getRecords().size(), 29);
    }

    @Test
    public void shouldReadAllRecordsFromAValidStream() throws IOException {
        DataFileHelper helper = new DataFileHelper();
        helper.parse(new File("Work/db-1x2.db"));

        List<String[]> records = helper.getRecords();
        for (Iterator<String[]> iterator = records.iterator(); iterator
                .hasNext();) {
            String[] record = iterator.next();
            for (int i = 0; i < record.length; i++) {
                assertNotNull(record[i]);
                assertEquals(record[i], record[i].trim());
            }

        }
    }

}
