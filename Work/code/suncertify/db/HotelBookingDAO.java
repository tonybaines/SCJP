/**
 * 
 */
package suncertify.db;

/**
 * @author tony
 *
 */
public class HotelBookingDAO implements DBMain {

    /* (non-Javadoc)
     * @see suncertify.db.DBMain#create(java.lang.String[])
     */
    @Override
    public int create(String[] data) throws DuplicateKeyException {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see suncertify.db.DBMain#delete(int)
     */
    @Override
    public void delete(int recNo) throws RecordNotFoundException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see suncertify.db.DBMain#find(java.lang.String[])
     */
    @Override
    public int[] find(String[] criteria) throws RecordNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see suncertify.db.DBMain#isLocked(int)
     */
    @Override
    public boolean isLocked(int recNo) throws RecordNotFoundException {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see suncertify.db.DBMain#lock(int)
     */
    @Override
    public void lock(int recNo) throws RecordNotFoundException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see suncertify.db.DBMain#read(int)
     */
    @Override
    public String[] read(int recNo) throws RecordNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see suncertify.db.DBMain#unlock(int)
     */
    @Override
    public void unlock(int recNo) throws RecordNotFoundException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see suncertify.db.DBMain#update(int, java.lang.String[])
     */
    @Override
    public void update(int recNo, String[] data) throws RecordNotFoundException {
        // TODO Auto-generated method stub

    }

}
