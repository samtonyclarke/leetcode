public class RemoveDuplicatesInSortedList {
    
    public static void main(String args[]) {
        RemoveDuplicatesInSortedList removeDuplicatesInSortedList = new RemoveDuplicatesInSortedList();

        ListNode one = new ListNode(1);
        ListNode oneB = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode threeB = new ListNode(3);
        ListNode threeC = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = oneB;
        oneB.next = two;
        two.next = three;
        three.next = threeB;
        threeB.next = threeC;
        threeC.next = four;

        removeDuplicatesInSortedList.deleteDuplicates(one);

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode origHead = head;
        ListNode traversing = head;
        
        while(traversing != null) {
            int currentVal = traversing.val;
            ListNode lookingAhead = traversing.next;
            while(lookingAhead != null) {
                if (lookingAhead.val != currentVal) {
                    break;
                }
                lookingAhead = lookingAhead.next;
            }
            traversing.next = lookingAhead;
            traversing = traversing.next;
            
        }
        
        return origHead;
    }
    
}
