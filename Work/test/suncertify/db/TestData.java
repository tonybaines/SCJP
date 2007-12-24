package suncertify.db;

import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class TestData {

    private DataFileHelper mockHelper;

    @Before
    public void setUp() {
        mockHelper = createMock(DataFileHelper.class);
    }

    @After
    public void verifyMockBehaviour() {
        replay(mockHelper);
    }

    @org.junit.Test()
    public void shouldCreateANewDataInstance() {
        DBMain data = new Data(mockHelper);
        assertNotNull(data);
    }

    @Test()
    public void shouldReturnARecordWhenTheNameMatches() {
        fail("Not implemented");
    }
}
