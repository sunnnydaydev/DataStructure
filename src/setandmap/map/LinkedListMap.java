package setandmap.map;

import sun.rmi.runtime.Log;

/**
 * Create by SunnyDay on 2019/03/07
 * 以链表为基础实现 映射
 * <p>
 * 类的设计 api 从上到下顺序看 比较简单 作者按照这个逻辑 排版的
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    /**
     * 节点
     * 内部类 方便我们使用
     */
    public class Node {
        K key;
        V value;
        Node next;

        /**
         * 构造
         * 完成节点元素初始化
         */
        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /**
         * 构造
         * <p>
         * 键不可以为空，通过键才能找到值
         */
        public Node(K key) {
            this(key, null, null);
        }

        /**
         * 构造
         * 各元素使用默认值
         */
        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }

    }

    private int size;//容量
    private Node dummyHead;// 虚拟头结点

    /**
     * 构造
     * 对虚拟头结点，size 完成初始化
     */
    public  LinkedListMap() {
        size = 0;
        dummyHead = new Node();

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 辅助类：本映射类的核心工具 使用后下面的api封装变得简单
     *
     * @param key
     * @function 根据键获得节点的引用
     */
    private Node getNode(K key) {

        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;//没有键为key的就返回空
    }

    /**
     * 是否包含key键
     * <p>
     * 使用辅助类
     */
    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }


    /**
     * 查找 key 对应的value
     * <p>
     * 使用辅助类
     */
    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    /**
     * 添加元素 （映射中key是唯一的）
     */
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);// 获得key对应的引用 判断是否存在此元素
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);//插入表头
            size++;
        } else {
            // TODO 已经存在key的话我们功能可以自己实现  抛异常或者覆盖已存在的key对应的value
            node.value = value;//此处我们选择覆盖value值
        }

    }

    /**
     * 修改元素
     */
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);// 获得key对应的引用 判断是否存在此元素
        if (node == null) {
            throw new IllegalArgumentException("key is not exist");
        } else {
            node.value = newValue;
        }
    }

    /**
     * 删除key对应的元素
     *
     * @param key 参考链表的删除任意元素
     */
    @Override
    public V remove(K key) {
        // 首先找到前一个节点
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }
        // 操作要删除的节点
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;// call gc
            size--;
            return prev.next.value;
        }
        return null;
    }


}
