import java.util.ArrayList;

public class SquaresOfSortedArray {
    public static void main(String args[]) {
        SquaresOfSortedArray squaresOfSortedArray = new SquaresOfSortedArray();
        squaresOfSortedArray.sortedSquares(new int[]{-7,-3,2,3,11});
    }

    public int[] sortedSquares(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i] * nums[i];
            if (result.isEmpty()) {
                result.add(n);
                continue;
            }
            boolean added = false;
            for (int j = 0; j < result.size(); j++) {
                if (n <= result.get(j)) {
                    result.add(j, n);
                    added = true;
                    break;
                }
            }
            if (!added) {
                result.add(n);
            }
        }
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            results[i] = result.get(i);
        }

        return results;
    }
}
