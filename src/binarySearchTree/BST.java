package binarySearchTree;

/**
 * Create by SunnyDay on 2019/02/16
 * binary search tree  二分搜索树
 * <p>
 * 类的泛型设计：
 * 可以存储任意类型设计为 泛型
 * 存储的对象要可比较性 故对泛型约束满足Comparable接口，或者其子类接口
 * <p>
 * 参考1 Comparable 的使用（Integer 类的比较源码 参考）
 * 参考2 super extends 的区别
 * <p>
 * 友情链接：
 * https://www.jianshu.com/p/82e4482f998c  泛型
 * https://www.jianshu.com/p/046586298bc2    比较器的运用
 */
public class BST<E extends Comparable<E>> {
    /**
     * 节点设计
     */
    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    // 根节点的设计  用于标记根节点
    private Node root;// 根节点
    private int size;// 元素数目

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 插入元素
     *
     * @param e 要插入的元素
     */
    public void add(E e) {
       /* if (root == null) {
            root = new Node(e);//创建根节点，把元素插入到根节点
            size++;
        } else {
            add(root, e);
        }*/

       // 优化
       root = add(root,e);
    }

    /**
     * 向以node为根的二分搜索树中添加元素 e
     *
     * @param e    要插入的元素
     * @param node 根节点
     *             此方法我们自己使用 ，本方法使用递归实现。
     *             思路：采用递归思想，则树的根是不断变化的。
     *             <p>
     *             addTest 为测试方法  add 为addTest的优化版
     */
    private void addTest(Node node, E e) {
        //元素重复 直接返回
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }
        // 开始递归调用  往下面遍历
        if (e.compareTo(node.e) < 0) {
            addTest(node.left, e);
        } else if (e.compareTo(node.e)>0){
            addTest(node.right, e);
        }
    }

    /**
     * 插入的递归优化 （参考addTest ）
     * */
    private Node add(Node node, E e) {
        // 为空时创建元素  这个空的就是要插入的位置
        if (node == null) {
            size++;
            return new Node(e);
        }
        // 递归调用 返回插入位置节点
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }
}
