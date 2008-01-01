package suncertify.db;

/**
 * @author tony
 * 
 */
public class SchemaEntry {

    private final String fieldName;
    private final short lengthOfField;

    /**
     * @param fieldName
     * @param lengthOfField
     */
    public SchemaEntry(String fieldName, short lengthOfField) {
        this.fieldName = fieldName;
        this.lengthOfField = lengthOfField;
    }

    @Override
    public String toString() {
        return this.fieldName + " (" + this.lengthOfField + " bytes)";
    }

    /**
     * @return the fieldName
     */
    public String getFieldName() {
        return this.fieldName;
    }

    /**
     * @return the lengthOfField
     */
    public short getLengthOfField() {
        return this.lengthOfField;
    }

}
