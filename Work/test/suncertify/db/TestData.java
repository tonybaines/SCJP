package suncertify.db;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class TestData {

    private IDataHelper mockHelper;

    @Before
    public void setUp() {
        mockHelper = createMock(IDataHelper.class);
    }

    @After
    public void verifyMockBehaviour() {
        replay(mockHelper);
    }

    @org.junit.Test()
    public void shouldCreateANewDataInstance() {
        // TODO: Placeholder test
        DBMain data = new Data(mockHelper);
        assertNotNull(data);
    }

    @Test()
    public void shouldReturnARecordWhenTheNameMatches() {
        fail("Not implemented");
    }
}
