/**
 *
 */
package suncertify.db;

/**
 * Data access class for the database.<p/>
 * 
 * N.B. Defined to implement DBMain as part of the Assignment. DO NOT CHANGE THE
 * NAME OR PACKAGE Subclassing DBMain should be appropriate.<p/>
 * 
 * Questions:
 * <li>What about reusing deleted records</li>
 * <li>Padding for fields to bring them up to size</li>
 * <li>Locking/unlocking/deleteing etc use a record number - this must be
 * treated as implied by the order from the DB, but may be subverted by
 * reordering in the GUI</li>
 */
public class Data implements DBMain {

    private final DataFile helper;

    /**
     * @param helper
     */
    public Data(DataFile helper) {
        this.helper = helper;
    }

    /*
     * (non-Javadoc)
     * 
     * @see suncertify.db.DBMain#create(java.lang.String[])
     */
    @Override
    public int create(String[] data) throws DuplicateKeyException {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     * 
     * @see suncertify.db.DBMain#delete(int)
     */
    @Override
    public void delete(int recNo) throws RecordNotFoundException {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     * 
     * @see suncertify.db.DBMain#find(java.lang.String[])
     */
    @Override
    public int[] find(String[] criteria) throws RecordNotFoundException {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     * 
     * @see suncertify.db.DBMain#isLocked(int)
     */
    @Override
    public boolean isLocked(int recNo) throws RecordNotFoundException {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     * 
     * @see suncertify.db.DBMain#lock(int)
     */
    @Override
    public void lock(int recNo) throws RecordNotFoundException {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     * 
     * @see suncertify.db.DBMain#read(int)
     */
    @Override
    public String[] read(int recNo) throws RecordNotFoundException {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     * 
     * @see suncertify.db.DBMain#unlock(int)
     */
    @Override
    public void unlock(int recNo) throws RecordNotFoundException {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     * 
     * @see suncertify.db.DBMain#update(int, java.lang.String[])
     */
    @Override
    public void update(int recNo, String[] data) throws RecordNotFoundException {
        throw new UnsupportedOperationException();
    }

}
