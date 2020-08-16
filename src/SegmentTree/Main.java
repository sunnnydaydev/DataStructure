package SegmentTree;

/**
 * Create by SunnyDay on 2020/08/15
 */
public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};
        SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(arr, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b; // 求和逻辑，用户自己实现。
            }
        });
        System.out.println(segmentTree);

        System.out.println(segmentTree.query(1,2));
    }
}
