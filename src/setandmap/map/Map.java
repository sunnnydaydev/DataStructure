package setandmap.map;

/**
 * Create by SunnyDay on 2019/03/06
 * 集合映射接口
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V value);

    int getSize();

    boolean isEmpty();
}
