package setandmap.map;


/**
 * Create by SunnyDay on 2019/03/07
 * 使用二分搜索树实现简单的map
 * <p>
 * ps：map的kev必须具有可比较性（通过key才能找到value）
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

    /**
     * 向二分搜索树中添加新的元素 key value
     */
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * public add  的辅助函数
     */
    private Node add(Node node, K key, V value) {
        // 书写递归条件
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {  // key相等 时 value后者覆盖
            node.value = value;

        }
        return node;
    }

    /**
     * 辅助函数
     * 返回以node为根节点的二分搜索树中key 所在的节点
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {  // >0时
            return getNode(node.right, key);
        }

    }

    /**
     * 使用getNode辅助函数
     */
    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }


    /**
     * 使用getNode 辅助方法
     */
    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    /**
     * 使用getNode工具类
     */
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException("key is not exist");
        }
        node.value = newValue;
    }

    /**
     * 二分搜索树的删除借助了几个方法
     *
     * */
    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if(node!=null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }
    /**
     * 删除以node为根节点的二分搜索树的最小节点
     * 返回删除节点后新的二分搜索树的节点
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 二分搜索树最小值
     *
     * */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }
    /**
     * 删除以node为根的二分搜索树中 键为k的节点  递归算法
     * <p>
     * 返回删除节点后，新的二分搜索树的根
     */
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        // 递归寻找
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            /*e.compareTo(node.e)==0
              找到了删除节点
              三种情况：
                  1 待删除的节点左子树为空
                  2  待删除节点的右子树为空
                  3 待删除节点左右子树都不为空
              */
            if (node.left==null){
                Node rightNode= node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right==null){
                Node leftNode= node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            /*
             * 待删除节点的左右孩子都不为空时思路：
             * 1 找到以待删除节点为根节点的最小节点
             * 2 用这个节点顶替待删除节点
             * */
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left=node.right=null;
            return successor;

        }

    }

}
