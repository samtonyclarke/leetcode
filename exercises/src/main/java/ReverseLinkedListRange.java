public class ReverseLinkedListRange {

    public static void main(String args[]) {
        ReverseLinkedListRange reverseLinkedListRange = new ReverseLinkedListRange();

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode result = reverseLinkedListRange.reverseBetween(one, 1, 4);
        printList(result); // Helper method to print the list
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Traverse to the node before the `left` position
        ListNode prior = dummy;
        for (int i = 1; i < left; i++) {
            prior = prior.next;
        }

        // Reverse the segment from `left` to `right`
        ListNode start = prior.next;
        ListNode reversedHead = reverseUntil(start, right - left + 1);

        // Reconnect the reversed segment
        prior.next = reversedHead;

        return dummy.next;
    }

    public ListNode reverseUntil(ListNode head, int count) {
        ListNode newHead = null;
        ListNode current = head;

        while (current != null && count > 0) {
            ListNode next = current.next;
            current.next = newHead;
            newHead = current;
            current = next;
            count--;
        }

        // Connect the tail of the reversed segment to the remaining list
        head.next = current;

        return newHead;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    
}
