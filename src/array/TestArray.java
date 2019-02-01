package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by SunnyDay on 2019/01/29
 */
public class TestArray {
    public static void main(String[] args){
      Array array = new Array(20);
      System.out.println(array.isEmpty());
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        array.addFirst(0);
        array.addLast(9);
        // TODO obj类的方法的补充
        array.add(2,100);
        System.out.println(array.toString());

        System.out.println(array.get(5));
        array.set(0,99);
        System.out.println(array.toString());
        System.out.println(array.contain(99));
        System.out.println(array.findIndex(3));
        array.remove(0);
        System.out.println(array.toString());
        array.removeElement(9);
        System.out.println(array.toString());
    }
}
