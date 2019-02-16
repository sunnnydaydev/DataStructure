package recursion;

/**
 * Create by SunnyDay on 2019/02/14
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    /**
     * 传入数组  构建链表
     *
     * @param arr 要传入的数组
     */
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];//吧第一个值付给头结点元素
        ListNode current = this;// 创建节点
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
    }
}
