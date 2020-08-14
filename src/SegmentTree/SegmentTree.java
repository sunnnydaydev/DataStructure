package SegmentTree;

/**
 * Create by SunnyDay on 2020/08/12
 * 线段树，基于数组方式实现。
 */
public class SegmentTree<E> {

    private E[] data; // 内部维护用户传递过来的数组
    private E[] tree;//线段树的数组实现

    /**
     * 构造，用户传一个数组，我们内部维护这个数组。
     */
    @SuppressWarnings("unchecked")
    public SegmentTree(E[] arr) {
        data = (E[]) new Object[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            data[i] = arr[i];
//        }
        // 使用for 遍历数组,给另一个数组赋值时。系统建议使用 System.arraycopy 函数
        System.arraycopy(arr, 0, data, 0, arr.length);
        tree = (E[]) new Object[4 * arr.length]; // 申请数组元素四倍空间

    }

    public int getSize() {
        return data.length;
    }

    /**
     * 获得指定索引的元素
     */
    public E get(int index) {
        if (0 < index || index >= data.length) {
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    /**
     * 返回完全二叉树中 给定索引所代表元素左孩子节点的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;// 公式 参考推导图
    }

    /**
     * 返回完全二叉树中 给定索引所代表元素有孩子节点的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;// 公式 参考推导图
    }

    /**
     * 在treeIndex 位置 表示区间为【left，right】的线段树
     * */
    private void buildSegmentTree(int treeIndex,int left,int right){
          // 递归终结条件
        if (left==right){
            tree[treeIndex] = data[left];//data[right] 意思一样
        }
    }
}
