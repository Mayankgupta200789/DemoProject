package patterns.fastAndSlowPointers;

import linkedlist.ListNode;

/**
 *      M
 * -----------
 * 1 -> 2 -> 3       ----|
 *       6       4       |    K
 *           5       ----|
 *
 * here slow will cover M + K           = T (total length)
 * here fast will cover M + K + C(i)    = 2T (total length)
 * take the diff of both nodes
 * MULTIPLY FIRST EQUATION BY 2 AND THEN TAKE DIFF
 * M + K - i(C) = 0 WHERE C IS CYCLE LENGTH
 * M + K = C(i), HERE I IS THE CONSTANT BY WHICH CYCLE IS TRAVERSED
    THUS, WHEN YOU MOVE M + K TIMES, YOUR CYCLE WILL BE COMPLETED CERTAIN NUMBER OF TIMES
  IN THE ABOVE EQUATION, IF YOU ONLY MOVE M STEPS, THEN YOU ARE LEFT OF K MORE STEPS TO COMPLETE THE CYCLE
    NOW M + K = C IF WE KEEP I AS 1, NOW FAST HAS ALREADY MOVED BY K STEPS IN THE CYCLE SO IF YOU
 MOVE M MORE STEPS FOR FAST POINTER, IT WILL REACH BEGINNING OF LOOP
 FOR SLOW, KEEP ON DOING THIS UNTIL YOU MEET FAST, THERE BY MEETING AT THE STARTING POINT.


 THIS IS VERY COMPLICATED QUESTION EVEN AFTER LOOKING AT SOLUTION, I WAS NOT CLEAR WHY IT WORKED


 THIS IS IR PROBLEM AND IN ORDER TO CRACK IT IN INTERVIEW, I HAVE TO REMEMBER THE TRICK
 OTHERWISE, IT CANNOT BE CROSSED IN INTERVIEW
 *
 *
 * Leetcode submitted successfully problem.
 */

public class IRLinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast ) {
                while(head != slow ){
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
