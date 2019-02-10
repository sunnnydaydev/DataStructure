package LinkedList;

/**
 * Create by SunnyDay on 2019/02/08
 * 不含有虚拟头结点
 */
public class LinkedListDemo<E> {

    // 节点的设计
    private class Node {
        E e;  // 元素
        Node next; // 指向下一个节点

        /**
         * @param e 元素
         * @param next 下一节点引用
         *
         * 初始化节点
         */
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        // 方便使用的构造
        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    // 设计链表头节点（链表必有的属性），链表的head和数组的size具有特殊意义
    // 数组的size用于跟踪尾元素，同样链表的head用于跟踪首个元素。
    private Node head;
    private int size;//链表内存的元素个数

    /**
     * 链表初始化
     */
    public LinkedListDemo() {
        head = null;
        size = 0;
    }
    // TODO 构造 根据传进的数组装换为链表

    /**
     * 链表的元素大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 链表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 链表头部添加元素
     *
     * @param e 要添加的元素
     */
    public void addFirst(E e) {
        /*
         * 步骤：
         * 1 申请新节点
         * 2 新节点的指针（next） 指向头结点（head）
         * 3 更改头结点
         *
         * 写时直接结合图解理解
         * 一句话：创建节点，吧新节点的指针指向头节点，更改头结点
         * */
//        Node node = new Node(e);
//        node.next = head;// 更改头结点
//        head = node;//（head就是标志，使node为头结点）

        //  优雅写法
        head = new Node(e, head);
        size++;
    }

    /**
     * 链表中添加元素（不是链表常用的方法）
     * 根据索引添加元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }
        // 插入头部时特别处理（头结点没有上一个元素）
        if (index == 0) {
            addFirst(e);
        } else {
            // 首先定义prev指向头部
            Node prev = head;
            // 循环找到要插入的上一个元素
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;//循环赋值到目标
            }
            // 具体插入操作  三步走
            // 1 创建节点
//            Node node = new Node(e);
//            // 2 创建节点的指针指向下一个节点（下一个节点的表示问题-- 前一个节点的next表示）
//            node.next = prev.next;
//            //上一个节点指向本节点
//            prev.next = node;

            // 优雅写法(类似参考插入首个节点，重要理解三个构造的意义)
            prev.next = new Node(e,prev.next);
            size++;
        }

    }
}
