package LinkedList;



/**
 * Create by SunnyDay on 2019/02/08
 */
public class TestLinkedList {
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }
        System.out.println("链表元素："+list.toString());
        list.add(2,666);
        System.out.println("插入元素666后："+list.toString());
        list.remove(2);
        System.out.println(list.toString());


    }
}
