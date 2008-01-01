package suncertify.db;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.easymock.annotation.RegularMock;

/**
 * 
 */
public class TestData extends UnitilsJUnit4 {

    @RegularMock
    private DataFileHelper mockHelper;

    private DBMain data;

    @Before
    public void setUp() {
        data = new Data(mockHelper);
    }

    @org.junit.Test()
    public void shouldCreateANewDataInstance() {
        assertNotNull(data);
    }

    @Test()
    public void shouldReturnARecordWhenTheNameMatches() throws Exception {
        data.find(new String[] { "Bob" });
    }
}
