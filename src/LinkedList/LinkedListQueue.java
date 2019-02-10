package LinkedList;

import queue.Queue;

/**
 * Create by SunnyDay on 2019/02/10
 * <p>
 * 链表实现队列
 * 由于使用了尾指针 故不再复用链表
 */
public class LinkedListQueue<E> implements Queue<E> {
    // 节点的设计
    private class Node {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

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

    private Node head;//头结点 （不再使用虚拟头结点 因为不需要中间添加删除操作，只在首部尾部）
    private Node tail; //   尾节点 最后一个节点的引用
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("can not dequeue,queue is empty");
        }
        Node temp = head; // 保存变量
        head = head.next;
        temp.next = null;
        // 只存在一个元素时
        if (head == null) {
            tail = null;
        }
        size--;
        return temp.e;
    }

    @Override
    public void enqueue(E e) {
        // 期初栈为空 tail = head
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            // 修改指向
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("can not dequeue,queue is empty");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue front");
        Node current = head;
        while (current != null) {
            sb.append(current.e+"->");
            current = current.next;
        }
        sb.append("tail null");
        return sb.toString();
    }
}
