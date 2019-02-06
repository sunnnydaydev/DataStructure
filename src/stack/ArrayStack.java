package stack;

import array.UseGeneric;

/**
 * Create by SunnyDay on 2019/02/05
 *
 * 基于通用动态数组实现
 */
public class ArrayStack<E> implements Stack<E> {
    private UseGeneric<E> array;// 成员  动态数组对象引用
    // 构造
    public ArrayStack(int capacity){
          array = new UseGeneric<>(capacity);
    }
    public ArrayStack(){
        array = new UseGeneric<>();
    }

     /**
      * 栈的容量
      * */
     public int getCapacity(){
        return array.getCapacity();
     }

     /**
      * 元素入栈
      * */
     @Override
     public void push(E e){
         //入栈就是把元素添加到栈的末尾
       array.addLast(e);
     }


   /**
    * 元素出栈
    * */
    @Override
    public E pop() {
        // 出栈 把当前的元素（栈的顶端栈顶）删除
        return array.removeLast();
    }

    /**
     * 查看栈顶元素（最后一个索引对应元素）
     * */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    /**
     *
     * 栈  toString 特有
     * */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ");
        sb.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if (i!=array.getSize()-1){
                sb.append(", ");
            }
        }
        sb.append("] :StackTop");
        return sb.toString();
    }
}
