package patterns.fastAndSlowPointers;

import linkedlist.ListNode;

public class LinkedListMiddle {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;


        while(fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
