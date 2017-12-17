package recursion;

import linkedlist.ListNode;

/**
 * @Author Mayank Gupta
 * @Date 11/6/17
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

        ListNode reverse = reverseLinkedList.reverseList(listNode, null);


    }

    public ListNode reverseList(ListNode a, ListNode prev) {

        if( a == null ) return prev;

        ListNode next = a.next;

        a.next = prev;
        prev = a;

        return reverseList(next, prev);


    }
}
