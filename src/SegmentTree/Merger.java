package SegmentTree;

/**
 * Create by SunnyDay on 2020/08/15
 */
public interface Merger<E> {
    // 吧泛型E 代表的两种类型元素融合成为一种元素。
    E merge(E a, E b);
}
