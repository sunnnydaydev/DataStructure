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

    /**
     * 向堆中添加元素
     */
    public void add(E e) {
        // 1 添加到末尾
        data.addLast(e);
        // 维护堆的性质（根父亲节点比较，看值是否合适，比父亲节点大就对调位置上浮，直到满足条件）
        siftUp(data.getSize() - 1);// 左后一个元素的索引
    }

    /**
     * @param k 元素的索引
     *          元素上浮
     */
    private void siftUp(int k) {
        //  E parent = data.get(parent(k));
        //循环执行:  当前元素与父节点左比较，不符合就交换位置 ,直到符合为止
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 堆中的最大元素
     * <p>
     * 最大堆中第一个元素就是最大元素
     */
    public E maxValue() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        return data.get(0);
    }

    /**
     * 取出堆中的最大元素
     */
    public E extractMax() {
        // 1 找出最大元素
        E maxV = maxValue();
        //2 吧最后一个元素替换最大元素
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        // 3 元素下浮处理（与左右节点比较）
        siftDown(0);
        return maxV;
    }

    /**
     * 元素下沉处理
     */
    private void siftDown(int k) {
        // 假如有左孩子时
        // 从根节点开始 当左孩子的 索引大于元素的最大索引时结束循环
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);// 记录左右孩子中最大孩子的索引，开始时默认左孩子的索引。
            // 如果有右孩子时 切有孩子比左大
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);// 较大孩子的索引为又孩子的
                /*
                 * 如果没有有孩子，或者又孩子的节点存的值比左孩子小 if不成立，则孩子中最大值为左孩子
                 * j就是用左孩子的索引
                 * */
            }
            // 根节点 给 最大孩子比较  满足条件结束循环
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);//更换元素
            k = j;//给k重新赋值
        }
    }

    /**
     * @param e 用户传来的元素
     *          <p>
     *          思路：替换堆顶元素，执行siftdown 满足堆的性质
     * @function 将堆顶的元素替换为 用户传来的元素
     * <p>
     * 注意：使用的组合也可完成 取出最大元素（maxValue），添加末尾add（），   两次 o(logn) 操作
     * 本思路就一次 o(logn)
     */
    public E replace(E e) {
        E temp = data.get(0);
        data.set(0, e);
        siftDown(0);
        return temp;
    }

    /**
     * Heapify
     * 将任意数组整理成堆的形状
     * 写成构造就行了
     */
    public MaxHeap(E[] arr) {
        data = new AutoArray<>(arr);// 元素存入数组，当成完全二叉树
        // 在整理成堆
        for (int i = parent(arr.length - 1); i >= 0; i--){
            siftDown(i);
        }

    }
}
