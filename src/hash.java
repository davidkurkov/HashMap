
/**
 * Created by david on 4/19/16.
 */
abstract interface hash {

    public void put(String key, int val); //** Add a new key-value pair to the map. If the key is already in the map then replace the old value with the new value. */

    public Integer get(String key); //* Given a key, return the value stored in the map or None otherwise. */

    public void delete(String key); //* Delete the key-value pair from the map. */

    public int size(); //* Return the number of key-value pairs stored in the map. */

    public boolean contains(String key); //* Return true if the given key is in the map, false otherwise. */

    public void clear(); //* clears all keys and values from HashMap */

    public String[] keys(); //* returns StringArray with all keys */

}
