package linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class LinkedListAdderReverse {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode next = new ListNode(9);
        listNode.next = next;
        next.next = new ListNode(9);
        next.next.next = new ListNode(9);
        next.next.next.next = new ListNode(9);

        ListNode listNode2 = new ListNode(1);
        ListNode next2 = new ListNode(9);
        listNode2.next = next2;
        next2.next = new ListNode(9);
        next2.next.next = new ListNode(9);
        next2.next.next.next = new ListNode(9);

        new LinkedListAdderReverse().addTwoNumbers(listNode,listNode2);


    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null )  return null;
        else if(l2 == null ) return l1;
        else if(l1 == null ) return  l1;


        ListNode newL1 = reverseLinkedList(l1);
        ListNode newL2 = reverseLinkedList(l2);

        int carry = 0 ;
        ListNode resultNode = null;
        while(newL1 != null && newL2 != null ) {


            int result = newL1.val + newL2.val + carry;
            int sum = result % 10;
            carry = result / 10 ;
            ListNode r = new ListNode(sum);

            r.next = resultNode;
            resultNode = r;
            newL1 = newL1.next;
            newL2 = newL2.next;

        }

        if(newL1 != null ) {

            while(newL1 != null ) {

                int result = newL1.val + carry;
                int sum = result % 10;
                carry = result / 10;
                ListNode r = new ListNode(sum);
                r.next = resultNode;
                resultNode = r;
                newL1 = newL1.next;
            }

        } else {

            while(newL2 != null ) {

                int result = newL2.val + carry;
                int sum = result % 10;
                carry = result / 10;
                ListNode r = new ListNode(sum);
                r.next = resultNode;
                resultNode = r;
                newL2 = newL2.next;
            }
        }

        return resultNode;



    }



    public ListNode reverseLinkedList(ListNode l ) {


        ListNode previous = null;
        ListNode current = l;

        while(l != null ) {

            ListNode next = l.next;
            l.next = previous;
            previous = l;
            l = next;
        }

        return previous;

    }


}
