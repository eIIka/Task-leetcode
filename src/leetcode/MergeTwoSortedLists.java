package leetcode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        mergeTwoLists(l1, l2);
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode current = head;

        while (list1 != null && list2 != null) {
           if (list1.val <= list2.val) {
               current.next = list1;
               list1 = list1.next;
           } else {
               current.next = list2;
               list2 = list2.next;
           }
           current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return head.next;
    }
}
