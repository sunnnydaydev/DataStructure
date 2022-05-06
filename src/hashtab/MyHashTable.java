package hashtab;

import java.util.TreeMap;

/**
 * Create by SunnyDay on 2022/05/06 14:23
 * custom hashTable base on TreeMap.
 */
public class MyHashTable<K, V> {
    private TreeMap<K, V>[] hashTable; //TreeMap base on red black tree.
    private int M;
    private int size;

    public MyHashTable(int M) {
        this.M = M;
        this.size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    /**
     * default constructor，default capacity is 97.
     */
    public MyHashTable() {
        this(97);
    }

    /**
     * calculate index
     */
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    /**
     * add element.
     */
    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
        }

    }

    /**
     * delete element.
     */
    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V element = null;
        if (map.containsKey(key)) {
            element = map.remove(key);
            size--;
        }
        return element;
    }

    /**
     * Detect whether the target element exists.
     */
    public boolean containKey(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    /**
     * query the target element.
     */
    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }
}

