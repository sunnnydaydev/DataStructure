package setandmap;

/**
 * Create by SunnyDay on 2019/03/06
 */
public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}
