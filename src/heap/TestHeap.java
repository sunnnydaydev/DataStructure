package heap;

import java.util.Random;

/**
 * Create by SunnyDay on 2019/03/08
 */
public class TestHeap {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (int i = 0; i < 10; i++) {
            maxHeap.add(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(maxHeap.extractMax());
        }
    }
}
