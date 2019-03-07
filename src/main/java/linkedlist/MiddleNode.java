package linkedlist;

/**
 * @author : Ge Xiantao
 * @date : 2019/2/20 17:16
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == null || head.next == null) {
            return head;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
