// Isha Gupta
// Nov 4, 2024

public class HashMap {
    private static final int DEFAULT_TABLE_SIZE = 100;
    private int tableSize;
    private int numKeys;
    private String[] keys;
    private String[] values;
    public static final int R = 256;

    public HashMap(){
        keys = new String[DEFAULT_TABLE_SIZE];
        values = new String[DEFAULT_TABLE_SIZE];
        numKeys = 0;
        tableSize = DEFAULT_TABLE_SIZE;
    }

    // Uses Horner's method to calculate the hash
    public int hash(String key){
        int hash = 0;
        for(int i = 0; i < key.length(); i++){
            hash = (hash*R + key.charAt(i)) % tableSize;
        }
        return hash;
    }

    // Adds a new key-value pair into their corresponding index
    public void add(String key, String value){
        resize();
        numKeys++;
        int index = hash(key);
        // If the spot is full, shift over
        while(keys[index] != null){
            // Mod by tableSize to loop around
            index = (index + 1) % tableSize;
        }
        keys[index] = key;
        values[index] = value;
    }

    // Returns the value corresponding with the given key
    public String get(String key){
        // Uses hash function to find the index that corresponds with the key/value pair
        int index = hash(key);
        // Check if the key you're looking at is correct or if you need to move over
        while(!key.equals(keys[index])){
            // If the slot is empty, your key value pair doesn't exist
            if(keys[index] == null) return null;
            index = (index + 1) % tableSize;
        }
        return values[hash(key)];
    }

    // If the table is over 50% full, double the table's size
    public void resize(){
        int alpha = numKeys/tableSize;
        if(alpha >= 0.5){
            tableSize *= 2;
        }
    }
}
