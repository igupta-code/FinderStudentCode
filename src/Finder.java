import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Isha Gupta
 **/

public class Finder {

    public static final String INVALID = "INVALID KEY";
    private HashMap hash = new HashMap();

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // Read in data line by line
        String line = br.readLine();
        String[] toAdd;
        // Until the end of the file, keep reading
        while(line != null){
            // Split the data so you can enter it into the hash table
            toAdd = line.split(",", 4);
            hash.add(toAdd[keyCol], toAdd[valCol]);
            // Move to next line
            line = br.readLine();
        }
        br.close();
    }

    public String query(String key){
        // Return the value corresponding to the key
        return hash.get(key);
    }
}