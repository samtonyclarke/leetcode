public class ReverseString {
    public static void main(String args[]) {
        ReverseString reverseString = new ReverseString();
//        reverse.reverseString(new char[]{'a', 'b', 'c'});
        reverseString.reverseString(new char[]{'a', 'b', 'c', 'f'});
    }

    public void reverseString(char[] string) {
        // must do in place
        int start = 0;
        int end = string.length - 1;
        while (start < end) {
            char temp = string[end];
            string[end] = string[start];
            string[start] = temp;
            start++;
            end--;
        }
        System.out.println(new String(string));

    }
}
