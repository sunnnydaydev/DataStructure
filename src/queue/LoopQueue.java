package queue;

/**
 * Create by SunnyDay on 2019/02/06
 * 循环队列（降低出队的时间复杂度）
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        //  多出来的一个容量（不使用） 便于维护循环队列
        data = (E[]) new Object[capacity + 1];
        // 初始化  （不做系统会帮你做）
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        //  多出来的一个容量（不使用） 便于维护循环队列
        this(10);
    }

    /**
     * 容量
     */
    public int getCapacity() {
        //循环队列中有个元素位置不使用
        return data.length - 1;
    }

    /**
     * 循环队列是否为空
     */
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 队列大小
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 循环队列重要方法： 出队
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("can not dequeue ，loopQueue is empty");
        }
        E temp = data[front];
        data[front] = null;// 从队列移除
        front = (front + 1) % data.length;// 重置front大小
        size--;
        // 缩容处理(缩小大小不能为0)
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return temp;
    }

    /**
     * 循环队列重要方法：入队
     */
    @Override
    public void enqueue(E e) {
        // 判断队列是否满了，满了就扩容
        if (front == (tail + 1) % data.length) {
            // 扩大为原来的2倍
            resize(getCapacity() * 2);
        }
        data[tail] = e; // 队列中添加元素
        tail = (tail + 1) % data.length;// 重置tail的大小（%是为了防止越界）
        size++;
    }


    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("loopQueue is empty!");
        }
        return data[front];
    }

    /**
     * 重置 容量（扩容）
     */
    private void resize(int newCapacity) {
        // 一样的道理，多申请个空间
        E[] newData = (E[]) new Object[newCapacity + 1];
        // 循环旧的数组进行
        for (int i = 0; i < size; i++) {
            // 原来的front并不一定在索引为0的位置，而是存在front+i的关系
            newData[i] = data[(front + i) % data.length];//防止越界（大小0 到 size-1 ）
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        //  System.out.println(Arrays.toString(data)); 默认会把没有的元素默认为0

        // 自定义 封装
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue size =  %d ,capacity = %d\n", size, getCapacity()));
        sb.append("front[");
        // 数字中的有效元素遍历
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            // 不是最后一个元素时拼接
            if ((i + 1) % data.length != tail) {
                sb.append(",");
            }
        }
        sb.append("]tail");
        return sb.toString();
    }
    // TODO  toString 与 resize 使用了两种不同的遍历方式
}
