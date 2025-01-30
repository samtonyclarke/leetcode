import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountingElements {

    public static void main(String args[]) {
        CountingElements countingElements = new CountingElements();
//        countingElements.countElements(new int[]{1,2,3});
//        countingElements.countElements(new int[]{1,1,3,3,5,5,7,7});
        countingElements.countElements(new int[]{1, 1, 2, 2});
    }

    public int countElements(int[] arr) {
        int count = 0;
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            if (set.contains((arr[i] + 1))) {
                count++;
            }
        }

        return count;
    }
}
