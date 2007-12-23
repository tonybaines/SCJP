package suncertify.db;

import static org.testng.Assert.*;
import static org.easymock.EasyMock.*;

import javax.xml.ws.ServiceMode;

import org.testng.annotations.*;

;

/**
 * 
 */
public class TestData {

    private IDataHelper mockHelper;

    @BeforeTest
    public void setUp() {
        mockHelper = createMock(IDataHelper.class);
    }

    @AfterTest
    public void verifyMockBehaviour() {
        replay(mockHelper);
    }

    @Test(enabled = true)
    public void shouldCreateANewDataInstance() {
        // TODO: Placeholder test
        DBMain data = new Data(mockHelper);
        assertNotNull(data);
    }

    @Test(enabled = true)
    public void shouldReturnARecordWhenTheNameMatches() {
        fail("Not implemented");
    }
}
