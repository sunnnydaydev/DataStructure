package array;

import java.util.ArrayList;

/**
 * Create by SunnyDay on 2019/02/01
 */
public class TestAutoArray {
    public static void main(String[] args){
        // 默认容量10
        AutoArray<Integer> array = new AutoArray<Integer>();
        System.out.println(array.isEmpty());
        // 扩充测试
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        array.addFirst(0);
        array.addLast(9);
        System.out.println(array.toString());

        // 缩小测试
        for (int i = 0; i < 5; i++) {
            array.removeLast();
        }
        System.out.println(array.toString());

    }
   /*
   log:

    true
    Array size =  12 ,capacity = 15
            [0,0,1,2,3,4,5,6,7,8,9,9]

    Process finished with exit code 0*/
}
