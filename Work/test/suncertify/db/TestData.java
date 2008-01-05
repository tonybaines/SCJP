package suncertify.db;

import static org.junit.Assert.assertNotNull;
import static org.easymock.classextension.EasyMock.expect;
import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;

@SuppressWarnings("all")
public class TestData extends UnitilsJUnit4 {

    private static final List<String[]> RECORDS;

    static {
        RECORDS = new ArrayList<String[]>();
        RECORDS.add(new String[] { "0", "Fawlty", "Bognor", "2", "false",
                "30.00", "2007/01/01", "12345678", "false" });
        RECORDS.add(new String[] { "1", "Hilton", "London", "5", "false",
                "130.00", "2007/01/02", "87654321", "false" });
    }

    @Mock
    private DataFile mockHelper;

    private DBMain data;

    @Before
    public void setUp() {
        data = new Data(mockHelper);
    }

    @Test()
    public void shouldCreateANewDataInstance() {
        assertThat(data).isNotNull();
    }

    @Test()
    public void shouldReturnARecordWhenTheNameMatches() throws Exception {
        expect(mockHelper.getRecords()).andReturn(RECORDS);
        EasyMockUnitils.replay();

        final int[] findResults = data.find(new String[] { "Hilton" });
        assertThat(findResults).hasSize(1).containsOnly(1);
    }
}
