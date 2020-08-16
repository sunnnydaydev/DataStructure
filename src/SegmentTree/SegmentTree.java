package SegmentTree;

/**
 * Create by SunnyDay on 2020/08/12
 * 线段树，基于数组方式实现。
 */
public class SegmentTree<E> {

    private E[] data; // 内部维护用户传递过来的数组
    private E[] tree;//线段树的数组实现
    private Merger<E> merger; // 融合器，消除类型之间的兼容性。

    /**
     * 构造，用户传一个数组，我们内部维护这个数组。
     */
    @SuppressWarnings("unchecked")
    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            data[i] = arr[i];
//        }
        // 使用for 遍历数组,给另一个数组赋值时。系统建议使用 System.arraycopy 函数
        System.arraycopy(arr, 0, data, 0, arr.length);
        tree = (E[]) new Object[4 * arr.length]; // 申请数组元素四倍空间
        // 默认情况下根节点的索引为0，区间左右端点为[0,data.length-1]
        buildSegmentTree(0, 0, data.length - 1);
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
     * 在treeIndex 位置 创建区间为[left，right]的线段树
     */
    private void buildSegmentTree(int treeIndex, int left, int right) {
        // 1、递归终结条件(递归到底，区间就一个元素)
        //(1)找到底的条件,写判断。
        //(2)return
        if (left == right) {
            tree[treeIndex] = data[left];//data[right] 意思一样
            return;
        }
        //2、区间元素为多个时，treeIndex 有左右孩子。
        int leftTreeIndex = leftChild(treeIndex);// 左孩子索引
        int rightTreeIndex = rightChild(treeIndex);// 右孩子索引
        // （1）总的区间有了，则中点也可找出。
        //int middle = (left + right) / 2;// 可能会整型溢出
        int middle = left + (right - left) / 2;
        // (2)treeIndex 位置子孩子的区间也就可标识出来了即：[left,middle],[middle+1,right]
        // (3) 有了索引，区间表示，则可递归创建左右子树作为线段树。
        buildSegmentTree(leftTreeIndex, left, middle);
        buildSegmentTree(rightTreeIndex, middle + 1, right);

        // treeIndex 索引对应区间元素和则为其左右子树元素之和
        //tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
        //Operator '+' cannot be applied to 'E', 'E'
        //思考：+ 的使用范围应该是同种类型。
//        Object a = 10;
//        Object b  = "a";
//        Object c = a+b;

        // 上面不仅出现类型兼容问题，而且+的处理过于局限，用户只能处理区间之和。这里使用接口融合器
        // 消除兼容问题，并且业务逻辑用户自己实现。求和，区间极值都可。
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    /**
     * @param queryL
     * @param queryR
     * @function 用户要查询的区间[queryL, queryR]
     */
    public E query(int queryL, int queryR) {
        if (queryL < 0 ||
                queryL > data.length ||
                queryR < 0 ||
                queryR > data.length ||
                queryL > queryR) {
            throw new IllegalArgumentException("index is illegal");
        }
        // 初始时从根节点开始查找，遍历整个线段树。
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 在根节点为treeIndex，区间为[left,right] 中查询[queryL,queryR] 区间
     */
    private E query(int treeIndex, int left, int right, int queryL, int queryR) {
        // 1、递归终结条件
        if (left == queryL && right == queryR) {
            return tree[treeIndex];
        }
        //2、划分区间
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int middle = left + (right - left) / 2;

        // 3、判断区间
        if (queryL >= middle + 1) { //[queryL,queryR] 区间在[left,right] 去见的右孩子区间
            return query(rightTreeIndex, middle + 1, right, queryL, queryR);
        } else if (queryR <= middle) {//[queryL,queryR] 区间在[left,right] 去见的左孩子区间
            return query(leftTreeIndex, left, middle, queryL, queryR);
        } else {//[queryL,queryR] 区间在[left,right] 区间的左右孩子都有
            E leftResult = query(leftTreeIndex, left, middle, queryL, middle);
            E rightResult = query(rightTreeIndex, middle + 1, right, middle + 1, queryR);
            return merger.merge(leftResult, rightResult);
        }
    }

    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("index is illegal");
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    /**
     * 更新以treeIndex 为根节点，区间为[left,right] 内索引为 index 的元素
     */
    private void set(int treeIndex, int left, int right, int index, E e) {
        if (left == right) {
            tree[index] = e;
            return;
        }
        //2、划分区间
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int middle = left + (right - left) / 2;
        if (index>=middle+1){
            set(rightTreeIndex,middle+1,right,index,e);
        }else  {
            set(leftTreeIndex,left,middle,index,e);
        }
        // 更新
        tree[treeIndex] =merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (null != tree[i]) {
                sb.append(tree[i]);
            } else {
                sb.append("null");
            }
            if (i != tree.length - 1) {
                sb.append(",");
            } else {
                sb.append("]");
            }
        }
        return sb.toString();
    }
}
