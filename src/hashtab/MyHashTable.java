package hashtab;

import java.util.TreeMap;

/**
 * Create by SunnyDay on 2022/05/06 14:23
 * custom hashTable base on TreeMap.
 */
public class MyHashTable<K, V> {

    // int 范围内素数
    private final int capacity[] = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469, 12582917, 25165843,
            50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    // about resize
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static int capacityIndex = 0;

    private TreeMap<K, V>[] hashTable; //TreeMap base on red black tree.
    private int M;
    private int size;

    public MyHashTable() {
        this.M = capacity[capacityIndex];
        this.size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
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
            // 避免越界
            if (size >= upperTol * M && capacityIndex + 1 < capacity.length) {
                capacityIndex++;
                resize(capacity[capacityIndex]);
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

            if (size <= lowerTol * M && capacityIndex - 1 >= 0) {
                capacityIndex--;
                resize(capacity[capacityIndex]);
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

