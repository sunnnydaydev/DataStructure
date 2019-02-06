package queue;

import array.UseGeneric;

/**
 * Create by SunnyDay on 2019/02/06
 */
public class ArrayQueue<E> implements Queue<E> {

    private UseGeneric<E> arrayQueue ;

    public ArrayQueue(int capacity){
     arrayQueue = new UseGeneric<>(capacity);
    }

    public ArrayQueue(){
        arrayQueue = new UseGeneric<>();
    }
    /**
     * 出队
     */
    @Override
    public E dequeue() {
        return arrayQueue.removeFirst();
    }

    /**
     * 入队
     */
    @Override
    public void enqueue(E e) {
      arrayQueue.addLast(e);
    }

    /**
     * 查看队的首个元素
     * */
    @Override
    public E getFront() {
        return arrayQueue.getFirst();
    }

    /**
     * 当前队的大小
     * */
    @Override
    public int getSize() {
        return arrayQueue.getSize();
    }

    /**
     * 是否为空
     * */
    @Override
    public boolean isEmpty() {
        return arrayQueue.isEmpty();
    }

    /**
     * 队列容量
     * */
    public int getCapacity(){
        return arrayQueue.getCapacity();
    }

    /**
     *
     * 队列  toString 特有
     * */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ");
        sb.append("front[");
        for (int i = 0; i < arrayQueue.getSize(); i++) {
            sb.append(arrayQueue.get(i));
            if (i!=arrayQueue.getSize()-1){
                sb.append(", ");
            }
        }
        sb.append("] :tail");
        return sb.toString();
    }
}
