package mypackage;

/**
 * Created by Nelly on 12.06.2016.
 */

import java.io.*;
import java.sql.ResultSet;

public class CSVRead {
    private File csvFile;

    public CSVRead() {
    }

    public synchronized void reader() {
        try {
            BufferedReader r = null;
            String line = "";

            Contact c = new Contact();
            final String csvSplit = ";";

            r = new BufferedReader(new FileReader(getCsvFile()));
            ResultSet rs = null;
            while ((line = r.readLine()) != null) {
                String[] arr = line.split(csvSplit);
                c.addContact(line);
            }

        } catch (FileNotFoundException ex) {
            ex.getLocalizedMessage();
        } catch (IOException ex) {
            ex.getLocalizedMessage();
        }

    }

    public File getCsvFile() {
        return csvFile;
    }

    public void setCsvFile(File csvFile) {
        this.csvFile = csvFile;
    }


}
