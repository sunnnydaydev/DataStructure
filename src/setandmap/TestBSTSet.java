package setandmap;

/**
 * Create by SunnyDay on 2019/03/06
 */
public class TestBSTSet {
    public static void main(String[] args) {
        // test  BSTSet
        BSTSet<String> bstSet = new BSTSet<>();
        bstSet.add("tom");
        bstSet.add("kate");
        bstSet.add("john");
        bstSet.add("tom");
        System.out.println(bstSet.getSize());

        // test LinkedListSet

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        linkedListSet.add("tom");
        linkedListSet.add("kate");
        linkedListSet.add("john");
        linkedListSet.add("tom");
        System.out.println(linkedListSet.getSize());

    }
}
