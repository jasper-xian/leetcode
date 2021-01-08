/*
Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
*/

class MyHashSet {
    
    boolean[][] set;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new boolean[1001][];
    }
    
    public int hash(int key) {
        return key % 1001;
    }
    
    public int pos(int key) {
        return key / 1001;
    }
    
    public void add(int key) {
        int hashkey = hash(key);
        
        if (set[hashkey] == null) {
            set[hashkey] = new boolean[1001];
        }
        set[hashkey][pos(key)] = true;
    }
    
    public void remove(int key) {
        int hashkey = hash(key);
        if (set[hashkey] != null) {
            set[hashkey][pos(key)] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashkey = hash(key);
        if (set[hashkey] == null)
            return false;
        return set[hashkey][pos(key)];
    }
}
