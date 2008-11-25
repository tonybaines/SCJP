package suncertify.services;

import static org.easymock.EasyMock.expect;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;

import suncertify.db.DBMain;
import suncertify.db.Schema;

@SuppressWarnings("all")
public class TestRoomBookingService extends UnitilsJUnit4 {

    private static final String[] IMPERFECT_NAME_CRITERIA = new String[] {
            "Blowfel", "Hull", null, null, null, null, null };
    private static final String[] IMPERFECT_LOCATION_CRITERIA = new String[] {
            "Blowfeld", "Hul", null, null, null, null, null };
    private static final String[] GOOD_CRITERIA = new String[] { "Blowfeld",
            "Hull", null, null, null, null, null };

    private static final String[] EXPECTED_RECORD = new String[] { "1",
            "Blowfeld", "Hull", null, null, null, null, null };

    @Mock
    private DBMain mockData;

    private RoomBookingService service;

    @Before
    public void setUp() {
        service = new RoomBookingService(mockData);
    }

    @Test
    public void shouldUseTheSuppliedDataSourceToFindARecordByNumber()
            throws Exception {
        expect(mockData.read(0)).andReturn(EXPECTED_RECORD);
        EasyMockUnitils.replay();

        assertThat(service.getRecord(0)).isNotEmpty()
                .isEqualTo(EXPECTED_RECORD);
    }

    @Test
    public void shouldUseTheSuppliedDataSourceToFindARecordByNumberFromAString()
            throws Exception {
        expect(mockData.read(0)).andReturn(EXPECTED_RECORD);
        EasyMockUnitils.replay();

        assertThat(service.getRecord("0")).isNotEmpty().isEqualTo(
                EXPECTED_RECORD);
    }

    @Test
    public void shouldUseTheSuppliedDataSourceToFindAllRecords()
            throws Exception {
        expect(
                mockData.find(new String[] { null, null, null, null, null,
                        null, null })).andReturn(new int[] { 1 });
        expect(mockData.read(0)).andReturn(EXPECTED_RECORD);
        EasyMockUnitils.replay();

        String[][] records = service.findAll();
        assertThat(records).isNotEmpty().hasSize(1);
        assertThat(records[0]).isNotEmpty().isEqualTo(EXPECTED_RECORD);
    }

    @Test
    public void shouldUseTheSuppliedDataSourceToFindARecordUsingTheSuppliedCriteria()
            throws Exception {
        expect(mockData.find(GOOD_CRITERIA)).andReturn(new int[] { 1 });
        expect(mockData.read(1)).andReturn(EXPECTED_RECORD);
        EasyMockUnitils.replay();

        String[][] records = service.findMatchingRecords("Blowfeld", "Hull");

        assertThat(records).isNotEmpty().hasSize(1);
        assertThat(records[0]).isNotEmpty().isEqualTo(EXPECTED_RECORD);
    }

    @Test
    public void shouldOnlyFindRecordsWhereTheNameCriterionMatchesExactly()
            throws Exception {
        expect(mockData.find(IMPERFECT_NAME_CRITERIA)).andReturn(
                new int[] { 1 });
        expect(mockData.read(1)).andReturn(EXPECTED_RECORD);
        EasyMockUnitils.replay();

        String[][] records = service.findMatchingRecords("Blowfel", "Hull");

        assertThat(records).isEmpty();
    }

    @Test
    public void shouldOnlyFindRecordsWhereTheLocationCriterionMatchesExactly()
            throws Exception {
        expect(mockData.find(IMPERFECT_LOCATION_CRITERIA)).andReturn(
                new int[] { 1 });
        expect(mockData.read(1)).andReturn(EXPECTED_RECORD);
        EasyMockUnitils.replay();

        String[][] records = service.findMatchingRecords("Blowfeld", "Hul");

        assertThat(records).isEmpty();
    }
}
