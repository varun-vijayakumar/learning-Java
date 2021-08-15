package com.javaprep.datastructures.hash;

import javax.swing.*;
import java.util.HashMap;


/**
 * Ideal lookup time - O(n), minimum collision.
 * Worst Case - O(n), max collision.
 * Collision - Multiple Keys having the same hash code.
 * keys mapped to an index of array.
 * @param <X>
 * @param <Y>
 */
public class HashBasic<X, Y> {
    private HashEntry[] data;
    private int capacity;
    private int size;

    public HashBasic(int totalSize) {
        this.capacity = totalSize;
        this.data = new HashEntry[this.capacity];
        this.size = 0;
    }

    /**
     * Get an value of a specific key in hashTable.
     * Complexity is based on how well the calculate Hash performs.
     * If hash is not big enough to avoid collisions, then complexity can
     * be linear - O(N). Else O(1)
     */
    public Y get(X key) {
        int hash = calculateHash(key);
        if (this.data[hash] == null) {
            return null;
        } else {
            return (Y)data[hash].getValue();
        }
    }

    /**
     * Add an entry into hashTable.
     * Complexity is based on how well the calculate Hash performs.
     * If hash is not big enough to avoid collisions, then complexity can
     * be linear - O(N). Else O(1)
     */
    public void put(X key, Y value) {
        int hash = calculateHash(key);
        data[hash] = new HashEntry(key, value);
        this.size++;
    }

    /**
     * Delete an entry from hashTable.
     * Time Complexity can vary from linear (O(N) to quadratic (O(N ^2)
     * based on the number of collisions present.
     * @param key
     * @return
     */
    public Y delete(X key) {
        Y value = get(key);
        if (value != null) {
            int hash = calculateHash(key);
            data[hash] = null;
            this.size--;
            //rearranging if there are collisions.
            hash = (hash + 1) % this.capacity;
            while(data[hash] != null) {
                HashEntry he = data[hash];
                data[hash] = null;
                //added the duplicates again.
                put((X)he.getKey(), (Y)he.getValue());
                //not really a new element add, so decrementing the size that was incremented by put.
                this.size--;
                //for other duplicates/collisions
                hash = (hash + 1) % this.capacity;
            }
        }
        return value;
    }

    /**
     * Check if a specific key exists in hashTable.
     * Time Complexity varies from O(1) to O(N) depending on
     * hash collisions.
     * @param key
     * @return
     */
    public boolean hasKey(X key) {
        int hash = calculateHash(key);

        if (data[hash] == null) {
            return false;
        } else if (data[hash].getKey().equals(key)) {
            return true;
        }

        return false;
    }

    /**
     * Check if a specific value exists in hashTable.
     * Time complexity is linear - O(N) since has to iterate over the
     * whole hash array.
     * @param value
     * @return
     */
    public boolean hasValue(Y value) {
        for (int i = 0; i < this.capacity; i++) {
            HashEntry entry = data[i];
            if (entry != null && entry.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calculate hashCode and return index of the hashTable array.
     * Time Complexity is O(1) to Linear - O(N) based on the number
     * of collisions present.
     * Choose a larger size of hashTable array to avoid collision.
     * @param key
     * @return
     */
    private int calculateHash(X key) {
        int hash = key.hashCode() % this.capacity;
        //this is required to avoid hash collision.
        //find an empty slot.
        while(this.data[hash] != null && !this.data[hash].getKey().equals(key)) {
            hash = (hash + 1) % this.capacity;
        }
        return hash;
    }

    public int getSize() {
        return size;
    }

    private class HashEntry<X,Y> {
        private X key;
        private Y value;

        public HashEntry(X key,Y value) {
            this.key = key;
            this.value = value;
        }


        public void setKey(X key) {
            this.key = key;
        }

        public void setValue(Y value) {
            this.value = value;
        }

        public X getKey() {
            return key;
        }

        public Y getValue() {
            return value;
        }
    }
}
