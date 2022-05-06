package hashtab;

import java.util.TreeMap;

/**
 * Create by SunnyDay on 2022/05/06 14:23
 * custom hashTable base on TreeMap.
 */
public class MyHashTable<K, V> {

    // about resize
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;

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
        this(initCapacity);
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
            if (size >= upperTol * M) {
                resize(2 * M);
            }
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

            if (size <= lowerTol * M && M / 2 >= initCapacity) {
                resize(M / 2);
            }
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

    private void resize(int newM) {
        // new array.
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }

        int oldM = M;
        this.M = newM;

        for (int i = 0; i < oldM; i++) {
            // TreeMap element in old  array.
            TreeMap<K, V> map = hashTable[i];

            // element put into newHashTable
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }
        // reset pointer
        this.hashTable = newHashTable;
    }
}

