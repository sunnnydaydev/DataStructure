package queue;

/**
 * Create by SunnyDay on 2019/02/06
 */
public class TestLoopQueue {
    public static void main(String[] args){
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.toString());

        queue.dequeue();
        System.out.println(queue.toString());
    }
}
