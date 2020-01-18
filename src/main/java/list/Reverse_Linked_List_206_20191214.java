package list;

import Utils.ListNode;
import Utils.ListUtils;

import java.util.List;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2019/12/12 10:04
 **/
public class Reverse_Linked_List_206_20191214 {

    public static void main(String[] args) {
        ListNode head = ListUtils.generateListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
//        ListUtils.printListNode(reverseList(head));
        ListUtils.printListNode(reverseList(head));
    }


    public static ListNode reverseList(ListNode head) {
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

}
