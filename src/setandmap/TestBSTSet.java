package setandmap;

/**
 * Create by SunnyDay on 2019/03/06
 */
public class TestBSTSet {
    public static void main(String[] args) {
        BSTSet<String> bstSet = new BSTSet<>();
        bstSet.add("tom");
        bstSet.add("kate");
        bstSet.add("john");
        bstSet.add("tom");

       System.out.println(bstSet.getSize());

    }
}
