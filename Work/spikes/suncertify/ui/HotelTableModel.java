package suncertify.ui;

import java.io.File;
import java.io.IOException;

import javax.swing.table.AbstractTableModel;

import suncertify.db.DataFile;

/**
 * 
 */
public class HotelTableModel extends AbstractTableModel {

    private final DataFile helper;

    /**
     * @throws IOException
     * 
     */
    public HotelTableModel() throws IOException {
        super();
        helper = new DataFile();
        helper.parse(new File("Work/db-1x2.db"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.table.TableModel#getColumnCount()
     */
    @Override
    public int getColumnCount() {
        return helper.getSchema().size();
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.table.TableModel#getRowCount()
     */
    @Override
    public int getRowCount() {
        return helper.getRecordFieldsCount();
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.table.TableModel#getValueAt(int, int)
     */
    @Override
    public Object getValueAt(int col, int row) {
        return helper.getRecords().get(col)[row];
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.table.AbstractTableModel#getColumnName(int)
     */
    @Override
    public String getColumnName(int index) {
        return toTitleCase(helper.getSchema().get(index).getFieldName());
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.table.AbstractTableModel#isCellEditable(int, int)
     */
    @Override
    public boolean isCellEditable(int arg0, int arg1) {
        return false;
    }

    private String toTitleCase(String original) {
        StringBuffer sb = new StringBuffer(original.substring(0, 1)
                + original.substring(1).toLowerCase());
        for (int i = 1; i < original.length() - 1; i++) {
            if (sb.charAt(i - 1) == ' ') {
                sb.setCharAt(i, original.substring(i, i + 1).toUpperCase()
                        .charAt(0));
            }
        }

        return sb.toString();
    }

}
