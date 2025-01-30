
import java.util.*;

public class ThreeArrays {

    public static void main(String[] args) {
        ThreeArrays app = new ThreeArrays();
//        long[] A = {10, 20, 30, 40, 50};
//        long[] B = {7, 5, 1, 2, 4};
        long[] A = {10, 20, 30, 40, 50};
        long[] B = {7, 5, 1, 2, 4};

        System.out.println(Arrays.toString(app.optimizedReplace(A, B))); // Expected: {20, 50, 40, 30, 20}
    }

    public long[] optimizedReplace(long[] A, long[] B) {
        int n = A.length;
        long[] toReturn = new long[n];

        // Step 1: Pair B values with their original indices and sort
        long[][] sortedB = new long[n][2];
        for (int i = 0; i < n; i++) {
            sortedB[i][0] = B[i]; // Value of B
            sortedB[i][1] = i;    // Original index of B[i]
        }
        Arrays.sort(sortedB, Comparator.comparingLong(o -> o[0]));

        // Step 2: For each element in B, find the closest value by binary search
        for (int i = 0; i < n; i++) {
            long target = B[i];
            int position = findClosestUsingBinarySearch(sortedB, target);

            // Compare neighbors to find the closest
            int closestIdx = position;
            long closestDiff = Long.MAX_VALUE;

            if (position > 0) { // Check the prior element
                long diffPrev = Math.abs(sortedB[position - 1][0] - target);
                if (diffPrev < closestDiff) {
                    closestIdx = position - 1;
                    closestDiff = diffPrev;
                }
            }
            if (position < n - 1) { // Check the next element
                long diffNext = Math.abs(sortedB[position + 1][0] - target);
                if (diffNext < closestDiff) {
                    closestIdx = position + 1;
                }
            }

            int originalIdx = (int) sortedB[closestIdx][1]; // Get original index of closest value in sortedB
            toReturn[i] = A[originalIdx];
        }

        return toReturn;
    }

    // Find the position of the closest element to `target` in sortedB using binary search
    private int findClosestUsingBinarySearch(long[][] sortedB, long target) {
        int left = 0, right = sortedB.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedB[mid][0] == target) {
                return mid; // Exact match found
            } else if (sortedB[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // At this point, `left` points to the smallest element >= target
        return left < sortedB.length ? left : sortedB.length - 1;
    }

}

