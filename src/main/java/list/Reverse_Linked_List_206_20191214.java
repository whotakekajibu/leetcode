package list;

import Utils.ListNode;
import Utils.ListUtils;

import java.util.List;

/**
 * @Description
 * @Date 2019/12/12 10:04
 **/
public class Reverse_Linked_List_206_20191214 {

    public static void main(String[] args) {
        ListNode head = ListUtils.generateListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
//        ListUtils.printListNode(reverseList1(head));
        ListUtils.printListNode(reverseList2(head));
    }


    public static ListNode reverseList1(ListNode head) {
        return helper(head, head.next);
    }

    public static ListNode helper(ListNode cur, ListNode next) {
        if (next == null) {
            return cur;
        }
        ListNode head = helper(next, next.next);
        next.next = cur;
        cur.next = null;
        return head;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode rev = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }

}
