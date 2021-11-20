package patterns.reverselinklist;

import linkedlist.ListNode;

import java.util.*;


class ReverseSubList {

    public static ListNode reverse(ListNode head, int p, int q) {



        ListNode previousPthNode = null;
        ListNode qthNodeNext = null;
        ListNode currentNode = head;
        ListNode pthNode = null;
        ListNode qthNode = null;
        ListNode previousNode = null;

        while(currentNode != null ) {

            if(currentNode.val == p ) {
                previousPthNode = previousNode;
                pthNode = currentNode;
            } else if( currentNode.val == q ) {
                qthNode = currentNode;
                qthNodeNext = currentNode.next;
            }

            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if( p == q  || pthNode == null || qthNode == null ) return head;

            previousNode = pthNode;
            currentNode = pthNode.next;
            while( currentNode.val != q ) {

                ListNode nextNode = currentNode.next;
                currentNode.next = previousNode;
                previousNode = currentNode;
                currentNode = nextNode;
            }
            ListNode nextNode = currentNode.next;
            currentNode.next = previousNode;


            if(previousPthNode != null ) previousPthNode.next = qthNode;
            pthNode.next = qthNodeNext;

        return currentNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 1, 5);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}