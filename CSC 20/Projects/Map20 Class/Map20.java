package Project3;

/**
 * The Map20 class maps unique keys
 * to a value.
 *
 * @author Marc Woodyard
 * @version April 14 2017
 */

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;

public class Map20<K, V> {
    private ArrayList<K> keys   = new ArrayList<>();
    private ArrayList<V> values = new ArrayList<>();

    /**
     * The Map20 class maps unique keys
     * to a value.
     * 
     * @param None.
     * @return None
     */
    public Map20() {
        //Inistalizes Map20.
    }

    /**
     * Returns the number of key-value mappings 
     * in this map.
     * 
     * @param None.
     * @return the number of key-value mappings in this map.
     */
    public int size() {
        return this.keys.size();
    }

    /**
     * Returns true if this map contains no key-value mappings.
     * 
     * @param None.
     * @return true if this map contains no key-value mappings.
     */
    public boolean isEmpty() {
        if (this.keys.size() == 0)
            return true;
        return false;
    }

    /**
     * Returns true if this map contains a mapping for the specified 
     * key.
     * 
     * @param key - key whose presence in this map is to be tested.
     * @return true if this map contains a mapping for the specified key.
     * @throws NullPointerException if parameter is null.
     */
    public boolean containsKey(Object key) {
        if (key == null)
            throw new NullPointerException("Parameters cannot be null.");
        else if (this.keys.contains(key))
            return true;
        return false;
    }

    /**
     * Returns true if this map maps one or more keys to the specified value.
     * 
     * @param value - value whose presence in this map is to be tested.
     * @return true if this map maps one or more keys to the specified value.
     * @throws NullPointerException if parameter is null.
     */
    public boolean containsValue(Object value) {
        if (value == null)
            throw new NullPointerException("Parameters cannot be null.");
        else if (this.values.contains(value))
            return true;
        return false;
    }

    /**
     * Returns the value to which the specified key is mapped, or 
     * null if this map contains no mapping for the key.
     * 
     * @param key - the key whose associated value is to be returned.
     * @return the value to which the specified key is mapped, or null 
     * if this map contains no mapping for the key.
     * @throws NullPointerException if parameter is null.
     */
    public V get(Object key) {
        if (key == null)
            throw new NullPointerException("Parameters cannot be null.");
        else if (this.keys.contains(key)) {
            int index = this.keys.indexOf(key);
            return this.values.get(index);
        }
        return null;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * 
     * @param key - key with which the specified value is to be associated.
     * @param value - value to be associated with the specified key.
     * @return the previous value associated with key, or null if there 
     * was no mapping for key.
     * @throws NullPointerException if parameters are null.
     */
    public V put(K key, V value) {
        if (key == null || value == null)
            throw new NullPointerException("Parameters cannot be null.");
        else if (this.keys.contains(key)) {
            int index = this.keys.indexOf(key);
            V previousValue = this.values.get(index);
            this.values.set(index, value);
            return previousValue;
        } else {
            this.keys.add(key);
            this.values.add(value);
            return null;
        }
    }

    /**
     * Removes the mapping for a key from this map if it is present.
     * 
     * @param key whose mapping is to be removed from the map.
     * @return the previous value associated with key, or null if 
     * there was no mapping for key.
     * @throws NullPointerException if parameter is null.
     */
    public V remove(Object key) {
        if (key == null)
            throw new NullPointerException("Parameters cannot be null.");
        else if (this.keys.contains(key)) {
            int index = this.keys.indexOf(key);
            V previousValue = this.values.get(index);
            this.keys.remove(index);
            this.values.remove(index);
            return previousValue;
        }
        return null;
    }

    /**
     * Removes the entry for the specified key only if it is currently 
     * mapped to the specified value.
     * 
     * @param key - key with which the specified value is associated.
     * @param value - value expected to be associated with the specified key.
     * @return true if the value was removed.
     * @throws NullPointerException if parameters are null.
     */
    public boolean remove(Object key, Object value) {
        if (key == null || value == null)
            throw new NullPointerException("Parameters cannot be null.");
        else if (this.keys.contains(key)) {
            int index = this.keys.indexOf(key);
            if (this.values.get(index) == value) {
                this.keys.remove(index);
                this.values.remove(index);
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all of the elements from this list. The 
     * list will be empty after this call returns.
     * 
     * @param None.
     * @return None
     */
    public void clear() {
        this.keys.clear();
        this.values.clear();
    }

    /**
     * Returns a Set view of the keys contained in this map.
     * 
     * @param None.
     * @return a set view of the keys contained in this map
     */
    public Set<K> keySet() {
        Set<K> result = new HashSet<>();
        Iterator<K> itr = keys.iterator();
        while (itr.hasNext()) {
            result.add(itr.next());
        }
        return result;
    }

    /**
     * Compares the specified object with this map for equality.
     * 
     * @param o - object to be compared for equality with this map.
     * @return boolean - true if the specified object is equal to this map.
     * @throws ClassCastException - Object o can't be cast as a map.
     * @throws NullPointerException - Object o contains a null value.
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        try {
            if (this == o)
                return true;

            if (!(o instanceof Map20))
                return false;

            Map20<K, V> map = (Map20<K, V>)o;

            if (map.size() != size())
                return false;

            Iterator<K> key = this.keys.iterator();
            Iterator<V> value = this.values.iterator();
            while (key.hasNext()) {
                K currentKey = key.next();
                V currentValue = value.next();
                if (map.get(currentKey) != currentValue)
                    return false;
            }
        } catch (NullPointerException b) {
            return false;
        } catch (ClassCastException a) {
            return false;
        }
        return true;
    }

    /**
     * Replaces the entry for the specified key only if currently 
     * mapped to the specified value.
     * 
     * @param key - key with which the specified value is associated.
     * @param oldValue - value expected to be associated with the specified key.
     * @param newValue - value to be associated with the specified key.
     * @return true if the value was replaced.
     * @throws NullPointerException if parameters are null.
     */
    public boolean replace(K key, V oldValue, V newValue) {
        if (key == null || oldValue == null || newValue == null) {
            throw new NullPointerException("Parameters cannot be null.");
        } else if (this.keys.contains(key) && this.values.contains(oldValue)) {
            int index = this.keys.indexOf(key);
            this.values.set(index, newValue);
            return true;
        }
        return false;
    }

    /**
     * Replaces the entry for the specified key. Else, return null.
     * 
     * @param key - key with which the specified value is associated
     * @param value - value to be associated with the specified key
     * @return the previous value associated with the specified key 
     * or null if a previous value does not exist.
     * @throws NullPointerException if parameters are null.
     */
    public V replace(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException("Parameters cannot be null.");
        } else if (this.keys.contains(key)) {
            int index = this.keys.indexOf(key);
            V oldValue = this.values.get(index);
            this.values.set(index, value);
            return oldValue;
        } else
            return null;
    }
}
