package stack;

/**
 * Create by SunnyDay on 2019/02/05
 */
public class TestStack {
    public static void main(String[] args){
      ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 4; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack.toString());

        arrayStack.pop();
        System.out.println(arrayStack.toString());
    }
}
