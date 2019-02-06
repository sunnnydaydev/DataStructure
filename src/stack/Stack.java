package stack;

/**
 * Create by SunnyDay on 2019/02/05
 * <p>
 * 自定义栈（与java api 中util包中stack栈同名）
 */
public interface Stack<E> {
    /**
     * 元素入栈
     */
    void push(E e);

    /**
     * 元素出栈
     */
    E pop();

    /**
     * 查看栈顶元素   有的使用 top命名 本处使用 peek
     * */
    E peek();

    /**
     * 栈中元素个数
     * */
    int getSize();

    /**
     * 栈 是否为空
     * */
    boolean isEmpty();


}
