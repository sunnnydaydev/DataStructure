package array;

/**
 * Create by SunnyDay on 2019/02/01
 * 测试泛型数组
 */
public class TestUseGeneric {
    public static void main(String[] args){
        UseGeneric<Integer> array = new UseGeneric<Integer>(20);
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
