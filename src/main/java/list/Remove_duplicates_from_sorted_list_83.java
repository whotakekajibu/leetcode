package list;

import Utils.ListNode;

/**
 * @Description
 * @Date 2020/5/16 14:57
 **/
public class Remove_duplicates_from_sorted_list_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode left = head, right = head.next;
        while (right != null) {
            while (right != null && left.val == right.val) {
                right = right.next;
            }
            left.next = right;
            left = left.next;
            if (right != null) {
                right = right.next;
            }
        }
        return head;
    }
}
