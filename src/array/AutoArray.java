package array;

/**
 * Create by SunnyDay on 2019/02/01
 */
public class AutoArray<E> {
    private E[] data; // 数组
    private int size;// 数组大小

    /**
     * @param capacity 根据传入的容量声明数组大小
     */
    public AutoArray(int capacity) {
        // 由于java 不支持泛型数组 我们可以使用Obj
        data = (E[]) new Object[capacity];
    }

    /**
     * 默认数组大小
     */
    public AutoArray() {
        this(10);
    }

    /**
     * 用户传来任意数组，存入我们动态数组
     */
    public AutoArray(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /**
     * 返回数组大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回数组容量
     * length java数组的唯一属性数组长度
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组判断空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组的最后一个元素之后添加元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 数组任意位置添加元素
     *
     * @param index 要插入的索引
     * @param e     要插入的元素
     */
    public void add(int index, E e) {
        // 首先还是检查数组是否满了

        // 判断插入数据的合法性（数组中数据是紧密排列，索引大于零）
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add element fail ,require index>0  or index<=size");
        }
        if (size == data.length) {
            // todo 动态扩充  参考ArrayList的扩容倍数
            resize((int) (1.5 * data.length));
        }


        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;

    }


    /**
     * 数组的头部添加元素（复用上面代码）
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 根据索引查询元素
     *
     * @param index 查询的索引
     * @return data[index] 直接返回元素
     * 静态数组必须开辟一定空间  没使用的不让访问，这就是直接返回元素，而不是返回静态数组的原因
     * 好处：用户永远只能查询已经使用空间上的数据
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get failed index is illegal");
        }
        return data[index];
    }

    /**
     * 元素的修改
     *
     * @param index 修改的索引
     * @param e     修改为的元素
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("set failed index is illegal");
        }
        data[index] = e;
    }

    /**
     * 数组中是否包含此元素
     *
     * @param e 元素
     * @return boolean 是否包含
     */
    public boolean contain(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素所在的索引(第一次出现的索引)
     *
     * @param e 元素
     * @return i 索引 ，-1 异常退出（没有元素）
     */
    public int findIndex(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 按照索引删除元素
     *
     * @param index 索引
     * @return int type   返回删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed index is illegal");
        }
        E tempElement = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; // 引用制空
        // 当数组元素减少过多时达到容量一半时 开始动态缩小容量
        if (size == data.length / 2) {
            resize(data.length / 2);
        }
        return tempElement;
    }

    /**
     * 删除第一个元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后个元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定的元素
     * <p>
     * 复用查找索引的方法
     * 本质通过索引删除元素
     * <p>
     * 只删除一个元素  存在相同时（可以自定义接口在实现）
     */
    public void removeElement(E e) {
        int index = findIndex(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * @param i 索引
     * @param j 索引
     * @function 交换两索引的元素
     */
    public void swap(int i, int j) {
        if (i < 0 || i > size || j < 0 || j > size) {
            throw new IllegalArgumentException("index is illegal");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    // 加注解的好处 防止覆盖出错，当父类没有此方法时报错
    @Override
    public String toString() {
        //  System.out.println(Arrays.toString(data)); 默认会把没有的元素默认为0

        // 自定义 封装
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array size =  %d ,capacity = %d\n", size, getCapacity()));
        sb.append("[");
        // 数字中的有效元素遍历
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            // 不是最后一个元素时拼接
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 数组扩容实现动态数组
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            // 复制
            newData[i] = data[i];
        }
        // 更改引用
        data = newData;
    }
}
