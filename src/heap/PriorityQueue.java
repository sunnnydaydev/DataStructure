package heap;

import queue.Queue;

/**
 * Create by SunnyDay on 2019/03/09
 * 基于堆（最大堆）的优先队列
 *
 *ps：java原装的优先队列底层使用的最小堆
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public E getFront() {
        return maxHeap.maxValue();
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public void enqueue(E e) {
       maxHeap.add(e);
    }

    // todo    使用线性结构实现（只是底层实现不同 时间复杂度可能不同）
}
