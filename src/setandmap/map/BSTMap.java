package setandmap.map;

/**
 * Create by SunnyDay on 2019/03/07
 * 使用二分搜索树实现简单的map
 * <p>
 * ps：map的kev必须具有可比较性
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    /**
     * 定义节点
     */
    private class Node {
        K key;
        V value;
        Node left;
        Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(K key, V value) {

    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void set(K key, V newValue) {

    }


}
