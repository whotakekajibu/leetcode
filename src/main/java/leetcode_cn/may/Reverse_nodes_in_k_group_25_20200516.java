package leetcode_cn.may;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @Description
 * @Date 2020/5/16 10:09
 **/
public class Reverse_nodes_in_k_group_25_20200516 {

    public static void main(String[] args) {
        ListNode head = ListUtils.generateListNode(new int[]{1, 2, 3, 4, 5, 6});
        ListUtils.printListNode(head);
        ListNode curHead = reverseKGroup(head, 3);
        ListUtils.printListNode(curHead);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int cnt = 0;
        ListNode curHead = head;
        while (head != null && cnt <= k) {
            cnt++;
            if (cnt == k) {
                ListNode next = head.next;
                ListNode reverse = reverse(curHead, k);
                curHead.next = reverseKGroup(next, k);
                return reverse;
            }
            head = head.next;
        }
        return curHead;
    }

    public static ListNode reverse(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode curReverse = reverse(head.next, k - 1);
        head.next.next = head;
        head.next = null;
        return curReverse;
    }

}
