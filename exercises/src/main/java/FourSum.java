import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum {

    public static void main(String args[]) {
        FourSum fourSum = new FourSum();
        fourSum.findIndices(new int[]{2,1}, new int[]{1,2});
//        fourSum.findIndices(new int[]{0, 1, 0, 3, 5}, new int[]{4, 0, 2, 0, 1});
    }

    public int[] findIndices(int[] arrA, int[] arrB) {
        Map<Integer, Integer> diffs = new HashMap<>();
        List<int[]> results = new ArrayList<>();

        for (int i = 0; i < arrA.length; i++) {
            int diff = arrA[i] - arrB[i];

            if (diffs.containsKey(-diff)) {
                int j = diffs.get(-diff);
                results.add(new int[]{j, i});
            }

            // Store the current index for the current difference
            if (!diffs.containsKey(diff)) {
                diffs.put(diff, i);
            }
        }

        // Sort results to find the pair with minimal indices
        results.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        // Return the first pair with minimal indices
        return results.isEmpty() ? new int[]{} : results.get(0);
    }


    // Helper function to generate all pair sums from arrB
    private Map<Integer, List<int[]>> getAllTwoPairSums(int[] arrB) {
        Map<Integer, List<int[]>> sums = new HashMap<>();

        for (int i = 0; i < arrB.length; i++) {
            for (int j = i + 1; j < arrB.length; j++) {
                int sum = arrB[i] + arrB[j];
                sums.computeIfAbsent(sum, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        return sums;
    }
    
}
