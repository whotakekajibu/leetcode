package leetcode_cn.april;

import Utils.ListNode;

/**
 * @Description
 * @Date 2020/4/14 10:18
 **/
public class TwoSumII_2020_04_14 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0, len2 = 0;
        ListNode head1 = l1, head2 = l2;
        while (head1 != null || head2 != null) {
            if (head1 != null) {
                head1 = head1.next;
                len1++;
            }
            if (head2 != null) {
                head2 = head2.next;
                len2++;
            }
        }
        ListNode res;
        if (len1 - len2 > 0) {
            res = add(l1, compliment(l2, len1 - len2));
        } else if (len1 - len2 < 0) {
            res = add(compliment(l1, len2 - len1), l2);
        } else {
            res = add(l1, l2);
        }
        if (res.val > 9) {
            res.val = res.val % 10;
            ListNode listNode = new ListNode(1);
            listNode.next = res;
            return listNode;
        }
        return res;
    }

    /**
     * @param node
     * @param delta
     * @return
     */
    public static ListNode compliment(ListNode node, int delta) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (delta > 1) {
            delta--;
            ListNode listNode = new ListNode(0);
            tail.next = listNode;
            tail = tail.next;
        }
        tail.next = node;
        return head;
    }

    public static ListNode add(ListNode l1, ListNode l2) {
        if (l1.next == null && l2.next == null) {
            return new ListNode(l1.val + l2.val);
        }
        ListNode add = add(l1.next, l2.next);
        int carry = 0;
        if (add.val > 9) {
            add.val = add.val % 10;
            carry = 1;
        }
        int curVal = l1.val + l2.val + carry;
        ListNode curNode = new ListNode(curVal);
        curNode.next = add;
        return curNode;
    }
}
