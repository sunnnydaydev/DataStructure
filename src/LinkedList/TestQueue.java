package LinkedList;

import queue.ArrayQueue;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Create by SunnyDay on 2019/02/10
 */
public class TestQueue {
    public static void main(String[] args){
        LinkedListQueue<Integer> queue = new LinkedListQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
    }
}
