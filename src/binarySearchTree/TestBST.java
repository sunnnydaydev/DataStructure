package binarySearchTree;



/**
 * Create by SunnyDay on 2019/02/17
 */
public class TestBST {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] arr = new int[]{5, 3, 6, 2, 4, 8};
        for (int i : arr) {
            bst.add(i);
        }
        //bst.preOrder();
        // 结果：5  3  2  4  6  8
        //             5
        //          /   \
        //         3     6
        //       /  \     \
        //      2     4    8

        System.out.println(bst);
        bst.inOrder();
        System.out.println("-----");
        bst.postOrder();
        bst.preOrderNR();
        System.out.println("-----");
        bst.levelOrder();
        System.out.println("-----最小：");
        System.out.println(bst.minimum());
        System.out.println("-----最大：");
        System.out.println(bst.maxmum());
    }
}
