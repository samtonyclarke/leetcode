public class RotateList {
    
    public static void main(String args[]) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        
        RotateList rotateList = new RotateList();

        rotateList.rotateRight(one, 2);
        
    }

    public ListNode rotateRight(ListNode head, int k) {

        int size = 0;
        ListNode current = head;
        while(current != null) {
            size++;
            current = current.next;
        }
        k = k % size;
        if (k == 0) {
            return head;
        }

        int stepsToNewHead = size - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        current = newHead;
        while (current.next != null) {
            current = current.next;
        }
        current.next = head;

        return newHead;
    }
    
    
    
}
