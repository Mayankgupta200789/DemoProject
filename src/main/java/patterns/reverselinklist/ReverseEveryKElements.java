package patterns.reverselinklist;


import linkedlist.ListNode;

class ReverseEveryKElements {

        public static ListNode reverse(ListNode head, int k) {

            ListNode previousNode = null;
            ListNode currentNode = head;
            ListNode beforeKthNode = null;
            ListNode kthNodeHead = head;

            int len = 0;

            while(currentNode != null ) {

                ListNode nextNode = currentNode.next;

                currentNode.next = previousNode;
                previousNode = currentNode;

                currentNode = nextNode;

                len++;

                if( len == k ) {

                    kthNodeHead.next = currentNode;
                    if(beforeKthNode != null ) {
                        beforeKthNode.next = previousNode;
                    } else {
                        head = previousNode;
                    }
                    previousNode = kthNodeHead;
                    beforeKthNode = previousNode;
                    kthNodeHead = currentNode;
                    len = 0;
                } else if (currentNode == null ) {
                    kthNodeHead.next = null;
                    if(beforeKthNode != null ) beforeKthNode.next = previousNode;
                }

            }

            return head;
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
            head.next.next.next.next.next = new ListNode(6);
            head.next.next.next.next.next.next = new ListNode(7);
            head.next.next.next.next.next.next.next = new ListNode(8);

            ListNode result = ReverseEveryKElements.reverse(head, 3);
            System.out.print("Nodes of the reversed LinkedList are: ");
            while (result != null) {
                System.out.print(result.val + " ");
                result = result.next;
            }
        }
    }

