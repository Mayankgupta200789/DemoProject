package companies.Klearnow;

import linkedlist.ListNode;

public class LinkedListAdder {

    public ListNode sum(ListNode n1, ListNode n2) {

        ListNode head = new ListNode(0);
        ListNode n3 = null;
        n3 = head;
        int carry = 0;


        while( n1 != null || n2 != null || carry != 0 ) {

            int input1 = n1 != null ? n1.val : 0;
            int input2 = n2 != null ? n2.val : 0;

            int sum = input1 + input2 + carry;

            int result = sum %10;
            carry = sum / 10;


            n3 = new ListNode(result);
            n3 = n3.next;

            if(n1 != null ) n1 = n1.next;
            if(n2 !=  null ) n2 = n2.next;
        }

        return head.next;



    }


}
