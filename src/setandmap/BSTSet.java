package setandmap;

import binarySearchTree.BST;

/**
 * Create by SunnyDay on 2019/03/06
 * 以二分搜索树为基础实现简单的Set
 *
 * Set集合的具体应用   统计不重复的元素
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;// 以二分搜索树为成员 相关操作围绕此操作实现

    public BSTSet() {
        bst = new BST<>();
    }

    /**
     * 所有操作使用bst操作就行
     *
     * */
    @Override
    public void add(E e) {
       bst.add(e);
    }

    @Override
    public void remove(E e) {

    }

    @Override
    public boolean contains(E e) {
        return bst.contain(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
