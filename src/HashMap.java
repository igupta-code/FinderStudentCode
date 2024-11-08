// Isha Gupta
// Nov 8, 2024

public class HashMap {
    private static final int DEFAULT_TABLE_SIZE = 773;
    public static final int R = 257;
    private int tableSize;
    private int numKeys;
    private String[] keys;
    private String[] values;

    public HashMap(){
        keys = new String[DEFAULT_TABLE_SIZE];
        values = new String[DEFAULT_TABLE_SIZE];
        numKeys = 0;
        tableSize = DEFAULT_TABLE_SIZE;
    }

    // Second constructor to double the hashmap
    public HashMap(int tableSize, int numKeys){
        this.tableSize = tableSize;
        keys = new String[tableSize];
        values = new String[tableSize];
        this.numKeys = numKeys;
    }

    // Uses Horner's method to calculate the hash
    public int hash(String key){
        int hash = 0;
        for(int i = 0; i < key.length(); i++){
            // Mod by tableSize to keep result in range of hashmap
            // Bc p = tableSize, initial tableSize should be a large prime
            hash = (hash*R + key.charAt(i)) % tableSize;
        }
        return hash;
    }

    // Adds a new key-value pair into their corresponding index
    public void add(String key, String value){
        resize();
        numKeys++;
        // Uses hash function to find the index that corresponds with the key/value pair
        int index = hash(key);
        // If the spot is full, shift over (resolves collisions)
        while(keys[index] != null){
            // Mod by tableSize to loop around
            index = (index + 1) % tableSize;
        }
        keys[index] = key;
        values[index] = value;
    }

    // Returns the value corresponding with the given key
    public String get(String key){
        int index = hash(key);
        // Check if the key you're looking at is correct or if you need to move over
        while(!key.equals(keys[index])){
            // If the slot is empty, your key value pair doesn't exist
            if(keys[index] == null) return Finder.INVALID;
            index = (index + 1) % tableSize;
        }
        return values[index];
    }

    // If the table is over 50% full, double the table's size
    public void resize(){
        // Check if resizing is needed
        int alpha = 100*numKeys/tableSize;
        if(alpha >= 50){
            // Create a new HashMap that's double the size and transfer values over to it
            HashMap doubled = new HashMap(2*tableSize, numKeys);
            for(int i = 0; i < tableSize; i++){
                if(keys[i] != null){
                    doubled.add(keys[i], values[i]);
                }
            }
            // Reset the HashMap variables to the new doubled version
            this.tableSize = doubled.tableSize;
            keys = doubled.keys;
            values = doubled.values;
            this.numKeys = doubled.numKeys;
        }
    }
}
