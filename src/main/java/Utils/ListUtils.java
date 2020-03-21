package Utils;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2019/12/12 10:12
 **/
public class ListUtils {
    public static ListNode generateListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        int i = 1;
        while (i < arr.length) {
            tail.next = new ListNode(arr[i++]);
            tail = tail.next;
        }
        return head;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
