/**
 * @version $Id$
 */
package suncertify.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 */
public class FileDumper {

    private File dbFile;

    /**
     * Create a new instance of FileDumper
     * @param string
     */
    public FileDumper(final String filePath) {
        dbFile = new File(filePath);
    }

    /**
     * @param out
     * @throws IOException
     */
    private void dumpContents(PrintStream out) throws IOException {
        FileInputStream is = new FileInputStream(dbFile);
        byte[] contents = new byte[5000];
        int size = is.read(contents);
        out.println("Size = " + size);
        for (int i = 0; i < size; i++) {
            out.print(Byte.toString(contents[i]) + ',');
        }
        out.flush();
    }

    public static void main(String[] args) {
        FileDumper fd = new FileDumper("Work/db-1x2.db");
        try {
            fd.dumpContents(System.out);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
