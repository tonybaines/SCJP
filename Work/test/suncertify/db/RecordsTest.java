package suncertify.db;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */
public class RecordsTest {
    private static final String[] EXPECTED_RECORD = new String[] { "0",
            "Fawlty", "Bognor", "2", "false", "30.00", "2007/01/01",
            "12345678", "false" };

    private static final String[] DELETED_RECORD = new String[] { "1", null,
            null, null, null, null, null, null, "true" };

    @Test
    public void shouldIdentifyADeletedRecord() throws Exception {
        assertTrue(Records.isDeleted(DELETED_RECORD));
    }

    @Test
    public void shouldIdentifyANonDeletedRecord() throws Exception {
        assertFalse(Records.isDeleted(EXPECTED_RECORD));
    }

    @Test
    public void shouldRepresentARecordAsAString() throws Exception {
        assertEquals(
                "[Rec No.=0, Name=Fawlty, City=Bognor, Max. persons=2, Smoking allowed?=false, Cost=30.00, Date available=2007/01/01, Owning Customer ID=12345678, Deleted?.=false]",
                Records.toString(EXPECTED_RECORD));
    }
}
