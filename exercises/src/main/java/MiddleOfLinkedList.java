public class MiddleOfLinkedList {


    public static void main(String args[]) {
        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        middleOfLinkedList.middleNode(one);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null) {
            if (fastPointer.next == null) {
                break;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
            if (fastPointer != null) {
                fastPointer = fastPointer.next;
            } else {
                slowPointer = slowPointer.next;
            }
        }
        return slowPointer;
    }

    

}
