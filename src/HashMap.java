// Isha Gupta
// Nov 4, 2024

public class HashMap {
    private static final int DEFAULT_TABLE_SIZE = 10;
    private int tableSize;
    private int numKeys;
    private String[] keys;
    private String[] values;
    public static final int R = 256;

    public HashMap(int numKeys){
        keys = new String[DEFAULT_TABLE_SIZE];
        values = new String[DEFAULT_TABLE_SIZE];
        this.numKeys = numKeys;
        tableSize = DEFAULT_TABLE_SIZE;
    }

    // Uses Horner's method to calculate the hash
    private int hash(String key){
        int hash = 0;
        for(int i = 0; i < key.length(); i++) {
            hash = (hash*R + key.charAt(i));
        }
        return hash;
    }

    // Adds a new key-value pair into their corresponding index
    private void add(String key, String value){
        int index = hash(key);
        keys[index] = key;
        values[index] = value;
    }

    // Returns the value corresponding with the given key
    private String get(String key){
        // Uses hash function to find the index that corresponds with the key/value pair
        return values[hash(key)];
    }

    // If the table is over 50% full, double the table's size
    private void resize(){
        int alpha = numKeys/tableSize;
        if(alpha >= 0.5){
            tableSize *= 2;
        }
    }
}
