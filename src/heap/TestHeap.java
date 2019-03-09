package heap;

import java.util.PriorityQueue;
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
        maxHeap.replace(11);
        for (int i = 0; i < 10; i++) {
            System.out.println(maxHeap.extractMax());
        }
        System.out.println("----------");

        Integer arr[] = new Integer[]{111,222,333};
        MaxHeap<Integer> heap = new MaxHeap<>(arr);
        System.out.println(heap.size());
        for (int i = 0; i < arr.length; i++) {
            System.out.println(heap.extractMax());
        }

    }
}
