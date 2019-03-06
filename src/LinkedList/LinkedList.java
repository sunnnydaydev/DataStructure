package LinkedList;

/**
 * Create by SunnyDay on 2019/02/08
 * <p>
 * 含有虚拟头结点
 */
public class LinkedList<E> {

    // 节点的设计
    private class Node {
        E e;  // 元素
        Node next; // 指向下一个节点

        /**
         * 根据用户传来的元素 节点引用 创建节点
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
    private Node dummyHead;
    private int size;

    /**
     * 链表初始化
     */
    public LinkedList() {
        //  虚拟节点的元素，指针默认为空   代表首个元素之前的那个空元素
        dummyHead = new Node(null, null);
        size = 0;
    }


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
     * 链表中添加元素（不是链表常用的方法）
     * 根据索引添加元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }
        Node prev = dummyHead;//索引为0的有效元素的前一个  也就是虚拟节点
        // 循环找到要插入的上一个元素
        for (int i = 0; i < index; i++) {
            prev = prev.next;//循环赋值到目标
        }
//        Node node = new Node(e);
//        node.next=prev.next;
//        prev.next = node;
//        优雅写法

        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 链表头部添加元素
     *
     * @param e 要添加的元素
     */
    public void addFirst(E e) {
        // 直接调用
        add(0, e);
    }

    /**
     * 链表尾部添加元素
     *
     * @param e 要添加的元素
     */
    public void addLast(E e) {
        // 直接调用
        add(size, e);
    }

    /**
     * 查询
     *
     * @param index 索引
     *              根据索引 查找元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        Node currentElement = dummyHead.next;//从索引为0也就是第一个元素开始遍历
        // 注意与add遍历的区别，两者遍历目的不同一个找节点，一个找元素。
        for (int i = 0; i < index; i++) {
            currentElement = currentElement.next;
        }
        return currentElement.e;
    }

    /**
     * 获得首个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获得末尾元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * @param index 索引
     * @param e     元素
     *              修改元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        Node currentElement = dummyHead.next;//从索引为0也就是第一个元素开始遍历
        for (int i = 0; i < index; i++) {
            currentElement = currentElement.next;
        }
        currentElement.e = e;
    }

    /**
     * 是否包含某元素
     *
     * @param e 元素
     */
    public boolean contain(E e) {

            // 遍历每个元素 发现返回true（第一次出现）
            Node currentElement = dummyHead.next;
            while (currentElement != null) {
                //equals元素的放置位置
                if (currentElement.e.equals(e)) {

                    return true;
                }
                currentElement = currentElement.next;
            }


        return false;
    }

    /**
     * @param index 索引
     *              删除链表中对应索引的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            // 找到待删除之前的节点
            prev = prev.next;
        }
        // 表示删除节点
        Node delNode = prev.next;
        // 修改指向
        prev.next = delNode.next;
        delNode.next = null;
        return delNode.e;
    }

    /**
     * 删除首个元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除末尾元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除任意元素
     */
    public void removeElement(E e) {
        Node prev = dummyHead;
        // 找到前一个元素
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }

        //要删除的元素非空时
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

    /**
     * 遍历 元素便利一遍输出
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currentElement = dummyHead.next;
        // 节点引用不为null
        while (currentElement != null) {
            sb.append(currentElement.e + "->");
            currentElement = currentElement.next;
        }
        sb.append("last[null]");

        return sb.toString();
    }
}
