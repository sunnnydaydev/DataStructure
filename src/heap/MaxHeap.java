package heap;

import array.AutoArray;

/**
 * Create by SunnyDay on 2019/03/08
 * 最大堆   使用数组实现
 * <p>
 * 存储任意元素  元素要有可比性（参看堆的定义原因2）
 * 原因：
 * 1 是一个完全二叉树
 * 2 每个父节点必须大于（或者小于）等于其子节点
 */
public class MaxHeap<E extends Comparable<E>> {
    private AutoArray<E> data;//以我们的动态数组为底层实现

    /**
     * 构造   初始化容量
     */
    public MaxHeap(int capacity) {
        data = new AutoArray<>(capacity);
    }

    /**
     * 构造   使用默认容量（参看数组底层源码）
     */
    public MaxHeap() {
        data = new AutoArray<>();
    }

    /**
     * 堆存的元素个数
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 堆 判空
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 下面三个辅助函数。   父亲节点，左孩子 有孩子 与数组索引关系（通过堆的完全二叉树树模型图推导）

    /**
     * 返回 给定索引所代表元素父节点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("root node don't have parent");
        }
        return (index - 1) / 2;// 公式 参考推导图
    }

    /**
     * 返回 给定索引所代表元素左孩子节点的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;// 公式 参考推导图
    }

    /**
     * 返回 给定索引所代表元素有孩子节点的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;// 公式 参考推导图
    }
}
