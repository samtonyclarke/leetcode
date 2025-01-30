import java.util.HashMap;
import java.util.Map;

public class SubarrayExactSum {
    public static void main(String args[]) {
        SubarrayExactSum subarrayExactSum = new SubarrayExactSum();    
        subarrayExactSum.subarraySum(new int[]{1, 2, 1, 2, 1}, 3);
//        subarrayExactSum.subarraySum(new int[]{0, 1, 2, 3, 4}, 5);
        
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);

        int ans = 0;
        int curr = 0;

        for (int num: nums) {
            curr += num;
            ans += counts.getOrDefault(curr - k, 0);
            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
        }

        return ans;
    }
    
    
}
