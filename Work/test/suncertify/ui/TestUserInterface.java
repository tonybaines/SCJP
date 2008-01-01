package suncertify.ui;

import static org.fest.swing.fixture.TableCell.TableCellBuilder.row;
import static org.junit.Assert.assertEquals;

import org.fest.swing.fixture.FrameFixture;
import org.junit.*;

public class TestUserInterface {
    private FrameFixture window;

    @Before
    public void setUp() {
        window = new FrameFixture(new UIBuilder()
                .buildUserInterface());
        window.show(); // shows the frame to test
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    public void shouldDisplayATableOfRoomRecords() {
        window.table().requireEnabled().requireVisible();
        assertEquals("Name 0", window.table().cell(row(0).column(0)).contents());
    }
}
