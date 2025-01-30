public class ReverseInteger {
    public static void main(String args[]) {
        ReverseInteger reverseInteger = new ReverseInteger();
        reverseInteger.reverse(123);
    }

    public int reverse(int x) {
        int reverse = 0;
        // int max = Integer.MAX_VALUE; == 2147483647 notice ends with 7
//         int min = Integer.MIN_VALUE; == -2147483648 notice ends with 8
        while (x != 0) {
            int rightMost = x % 10;
            x = x / 10;
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && rightMost > 7)
            ) return 0; //preempt overflow
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && rightMost < -8)
            ) return 0; // preempt overflow
            reverse = reverse * 10 + rightMost; // no overflow
        }
        return reverse;
    }
}
