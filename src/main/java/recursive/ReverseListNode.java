package recursive;

import Utils.ListNode;

public class ReverseListNode {
    static ListNode res;

    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        list.next = new ListNode(1);
        list.next.next = new ListNode(2);
        list.next.next.next = new ListNode(3);
        ListNode ans = reverseList1(list);
        System.out.println(ans.val);
    }

    public static ListNode reverseList(ListNode head) {
        dfs(head);
        return res;
    }

    static ListNode dfs(ListNode head) {
        if (head == null || head.next == null) {
            res = head;
            return head;
        }
        ListNode t = dfs(head.next);
        if (t != null) {
            t.next = head;
        }
        head.next = null;
        return head;
    }

    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
