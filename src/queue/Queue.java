package queue;

/**
 * Create by SunnyDay on 2019/02/06
 * <p>
 * 队列接口（注意java 原生的Queue接口继承了Collection接口）
 */
public interface Queue<E> {
    E dequeue();
    E getFront();
    int getSize();
    void enqueue(E e);
    boolean isEmpty();
}
