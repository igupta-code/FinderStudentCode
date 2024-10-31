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

    private static final String INVALID = "INVALID KEY";
    private static final int p = 249998741;
    int[] hashMap = new int[p];

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        String[] line = new String[1];
        String read  = br.readLine();
        line = read.split(",", 4);
        // You will get ur key with line[keyCol] and
        while(line != null){
            // keep reading
        }

        br.close();
    }

    public String query(String key){
        return INVALID;
    }
}