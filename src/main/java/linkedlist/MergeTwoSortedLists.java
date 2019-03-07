package linkedlist;

/**
 * @author : Ge Xiantao
 * @date : 2019/2/20 14:49
 */
public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head;
        ListNode p1 = l1;
        ListNode p2 = l2;
        if (l1.val <= l2.val) {
            head = l1;
            p1 = p1.next;
        } else {
            head = l2;
            p2 = p2.next;
        }
        ListNode realHead = head;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                head.next = p1;
                head = p1;
                p1 = p1.next;
            } else {
                head.next = p2;
                head = p2;
                p2 = p2.next;
            }
        }
        if (p1 == null) {
            head.next = p2;
        }
        if (p2 == null) {
            head.next = p1;
        }
        return realHead;
    }

    public static ListNode mergeRecursively(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeRecursively(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeRecursively(l1, l2.next);
            return l2;
        }
    }

}
