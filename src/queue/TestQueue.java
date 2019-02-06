package queue;

/**
 * Create by SunnyDay on 2019/02/06
 */
public class TestQueue {
    public static void main(String[] args){
     ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.toString());

        queue.dequeue();
        System.out.println(queue.toString());
    }
}
