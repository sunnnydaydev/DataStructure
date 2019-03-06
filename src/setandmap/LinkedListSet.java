package setandmap;


import LinkedList.LinkedList;

/**
 * Create by SunnyDay on 2019/03/06
 * <p>
 * 以我们写的链表为基础 实现Set的简单功能
 * 链表为我们自己写的非java原装的（参考前面我们封装的链表）
 * 参考链接：https://blog.csdn.net/qq_38350635/article/details/86906834
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<E>();
    }

    /**
     * 不能添加重复元素
     * 检查是否包含，不包含再添加。
     */
    @Override
    public void add(E e) {

        if (!list.contain(e)) {
            list.addFirst(e);// 添加头部复杂度小为1
        }
    }

    @Override
    public void remove(E e) {
     list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contain(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
