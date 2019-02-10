package LinkedList;
/**
 * Create by SunnyDay on 2019/02/09
 */
public class LinkedListStackTest {
    public static void main(String[] args){
        LinkedListStack stack = new LinkedListStack();
        for (int i = 0; i < 4; i++) {
            stack.push(i);
        }
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
    }
}
