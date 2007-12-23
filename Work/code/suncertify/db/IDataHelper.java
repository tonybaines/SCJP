package suncertify.db;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 
 */
public interface IDataHelper {

    public abstract void parse(final File source) throws IOException;

    public abstract short getRecordFieldsCount();

    public abstract int getStartOfDataOffset();

    public abstract int getRecordCount();

    public abstract List<String[]> getRecords();

    /**
     * @return the schema
     */
    public abstract List<SchemaEntry> getSchema();

}