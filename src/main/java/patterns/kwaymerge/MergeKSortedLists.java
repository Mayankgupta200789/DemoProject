//package patterns.kwaymerge;
//
//import java.util.*;
//
//class ListNode {
//    int value;
//    ListNode next;
//
//    ListNode(int value) {
//        this.value = value;
//    }
//}
//
//class MergeKSortedLists {
//
//    public static ListNode merge(ListNode[] lists) {
//        ListNode previous = null;
//        ListNode current = null;
//
//        for(int i = 0 ; i < lists.length; i++ ) {
//            ListNode listNode1 = previous;
//            ListNode listNode2 = lists[i];
//
//            while(listNode1 != null || listNode2 != null ) {
//
//                if(listNode1 != null && listNode2 != null
//                        && listNode1.value > listNode2.value ) {
//                    result = new ListNode(listNode2.value);
//                } else if( listNode1 != null && listNode2 != null ) {
//                    result = new ListNode(listNode2.value);
//                } else if ( listNode1 != null ) {
//                    result = new ListNode(listNode2.value);
//                } else {
//                    result = new ListNode(listNode2.value);
//                }
//
//                if(listNode1 != null ) listNode1 = listNode1.next;
//                if(listNode2 != null ) listNode2 = listNode2.next;
//                if(previous == null )
//            }
//        }
//        return head;
//    }
//
//    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(6);
//        l1.next.next = new ListNode(8);
//
//        ListNode l2 = new ListNode(3);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(7);
//
//        ListNode l3 = new ListNode(1);
//        l3.next = new ListNode(3);
//        l3.next.next = new ListNode(4);
//
//        ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
//        System.out.print("Here are the elements form the merged list: ");
//        while (result != null) {
//            System.out.print(result.value + " ");
//            result = result.next;
//        }
//    }
//}
//
