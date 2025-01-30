public class MergeList {
    
    public static void main(String args[]) {
        MergeList mergeList = new MergeList();
        
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        
        l1.next = l3;
        l3.next = l5;
        l2.next = l4;
        l4.next = l6;
        mergeList.mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode l1current = l1;
        ListNode l2current = l2;
        ListNode newHead;
        if (l1current.val < l2current.val) {
            newHead = l1current;
            l1current = l1current.next;
        } else {
            newHead = l2current;
            l2current = l2current.next;
        }
        ListNode current = newHead;

        while(l1current != null && l2current != null) {
            if (l1current.val < l2current.val) {
                current.next =l1current;
                l1current = l1current.next;
            } else {
                current.next = l2current;
                l2current = l2current.next;
            }
            current = current.next;
        }
        if (l1current != null) {
            current.next = l1current;
        }
        if (l2current != null) {
            current.next = l2current;
        }

        // TODO: Write your code here
        return newHead;
    }
    
}
