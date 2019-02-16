package recursion;

/**
 * Create by SunnyDay on 2019/02/14
 */

import LinkedList.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
/*
* Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
* */
class Solution {

    /**
     * 1 使用头结点解决
     */
    public ListNode removeElements_1(ListNode head, int val) {
        /*
         * 使用头结点
         * 1 判断头部（没有上一节点）
         * 2 中间（先找待删除节点上一节点）
         * */

        // 1 首先判断首个元素是否为目标元素
        //  有可能删除过第一个元素后，后面元素还是这个元素  故使用while
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        // 2 有可能整个链表都是次元素
        if (head == null) {
            return head;//return空一样
        }
        //3 中间处理
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = prev.next.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    /**
     * 2 使用虚拟头结点
     */
    public ListNode removeElements_2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);//声明虚拟头结点
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = prev.next.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 3 使用递归
     */
    public ListNode removeElements_3(ListNode head, int val) {

        // 得到去掉头结点的剩余链表
//        ListNode res = removeElements_3(head.next, val);
//        // 头结点为目标节点直接返回
//        if (head.val == val){
//            return head;
//        }else{
//            // 重新调用
//            head.next = res;
//            return head;
//        }

        // 空链表
        if (head == null) {
            return null;
        }
        // 优雅写法
        head.next = removeElements_3(head.next, val);
        return head.val == val ? head.next : head;
    }
}