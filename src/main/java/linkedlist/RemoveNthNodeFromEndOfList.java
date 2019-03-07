package linkedlist;

/**
 * @author : Ge Xiantao
 * @date : 2019/2/20 15:29
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }
        ListNode pre = null;
        ListNode next = slow.next;
        while (fast.next != null) {
            pre = slow;
            slow = slow.next;
            next = slow.next;
            fast = fast.next;
        }
        if (pre == null && next == null) {
            return null;
        } else if (pre == null) {
            return next;
        }
        pre.next = next;
        return head;
    }

}
