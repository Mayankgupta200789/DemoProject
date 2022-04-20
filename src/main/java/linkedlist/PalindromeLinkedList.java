package linkedlist;


/**
 * @Author Mayank Gupta
 * @Date 8/27/17
 */
public class PalindromeLinkedList {

    public int lPalin(ListNode A) {

        if( A == null ) {
            return 0;
        }

        ListNode head = A;

        int len = getLength(A);

        if( len == 1 ) {
            return 0;
        }
        // 1 -> 2 -> 3 <- 4 <- 5


        ListNode slow = A;

        int i = 1;

        while(i < (len/2)) {

            slow = slow.next;
            i++;
        }

        ListNode middleNext = slow.next;

        ListNode nodeBeforeMiddle = reverse(head,slow.next);

        if( len % 2 != 0) {
            ListNode startNodeForCompare = middleNext.next;
            return compare(startNodeForCompare,nodeBeforeMiddle);
        } else {
            return compare(middleNext,nodeBeforeMiddle);
        }


    }

    private int getLength(ListNode input) {

        int len = 0;

        while( input != null ) {
            len++;
            input = input.next;
        }

        return len;
    }

    private ListNode reverse(ListNode input,ListNode limit) {

        ListNode prev = null;
        ListNode current = input;
        ListNode next = current.next;

        while( current != limit ) {

            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }

        return prev;
    }


    private int compare(ListNode input1,ListNode input2) {

        while(input1 != null && input2 != null ) {

            if(input1.val != input2.val )  {
                return 0;
            }
            input1 = input1.next;
            input2 = input2.next;
        }

        if( input1 != null || input2 != null ) {
            return 0;
        } else {
            return 1;
        }


    }
}
