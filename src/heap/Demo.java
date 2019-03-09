package heap;

import sun.rmi.runtime.Log;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Create by SunnyDay on 2019/03/09
 */
public class Demo {
    public static void main(String[] args) {

        float arr[] = new float[100];
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            float v = random.nextInt(1000);
            arr[i] = v;

        }
        Arrays.sort(arr);
        for (int i = 0; i < 100; i++) {
            System.out.println("第" + (i + 1) + "个数" + arr[i]);
        }


        // 首先让前10个放入优先队列
        PriorityQueue<Float> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            priorityQueue.add(arr[i]);
        }
        for (int i=11;i<100;i++){
            if (arr[i]> priorityQueue.peek()){
                priorityQueue.remove();
                priorityQueue.add(arr[i]);
            }
        }
        System.out.println("队列中最终数字：");
        for (int i = 0; i < 10; i++) {
            System.out.println(priorityQueue.remove());
        }
    }
}
