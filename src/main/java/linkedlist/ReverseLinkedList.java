package linkedlist;

/**
 * @author : Ge Xiantao
 * @date : 2019/2/20 10:55
 */
public class ReverseLinkedList {

    public static ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = next;
            head = next;
        }
        return newHead;
    }

    public static ListNode reverseRecursively(ListNode head) {
        return realReverse(head, null);
    }

    private static ListNode realReverse(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return realReverse(next, head);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode reverse = reverseRecursively(head);
        while (reverse != null) {
            System.out.print(reverse.val + " -> ");
            reverse = reverse.next;
        }
    }

}
