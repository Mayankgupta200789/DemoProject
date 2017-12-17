package linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author Mayank Gupta
 * @Date 8/27/17
 */
public class PalindromeLinkedListTest {

    private PalindromeLinkedList palindromeLinkedList;

    @Before
    public void setUp() throws Exception {

        palindromeLinkedList = new PalindromeLinkedList();
    }

    @Test
    public void lPalin() throws Exception {

        ListNode listNode = new ListNode(1);
        ListNode next = new ListNode(1);
        listNode.next = next;
        next.next = new ListNode(2);
        next.next.next = new ListNode(1);
        next.next.next.next = new ListNode(1);

        Assert.assertEquals(1,palindromeLinkedList.lPalin(listNode));
    }

}