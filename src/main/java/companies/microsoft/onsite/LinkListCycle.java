package companies.microsoft.onsite;

import linkedlist.ListNode;

public class LinkListCycle {

    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }

        return false;

    }
}
