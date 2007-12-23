package suncertify.db;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import org.testng.annotations.Test;

public class TestDataFileHelper {

    private static final byte[] VALID_START_OF_FILE = new byte[] { 0x00, 0x00,
            0x01, 0x02, 0x00, 0x00, 0x00, 0x4a, 0x00, 0x07 };
    private static final Logger LOG = Logger.getLogger(TestDataFileHelper.class
            .getName());

    @Test(enabled = true)
    public void shouldReadMetaDataFromAValidStream()
            throws FileNotFoundException, IOException {
        DataFileHelper helper = new DataFileHelper();
        helper.parse(new File("Work/db-1x2.db"));
        assertEquals(helper.getStartOfDataOffset(), 74);
        assertEquals(helper.getRecordFieldsCount(), 7);
        assertEquals(helper.getSchema().size(), 7);
        assertEquals(helper.getRecordCount(), 29);
        assertEquals(helper.getRecords().size(), 29);
    }

}
