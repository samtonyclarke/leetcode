import java.util.HashMap;
import java.util.Map;

public class ThreeSomeMulti {

    public static void main(String args[]) {
        ThreeSomeMulti threeSomeMulti = new ThreeSomeMulti();
        threeSomeMulti.threeSumMulti(new int[]{2, 1, 3},6 );
    }

    public int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        int mod = 1000000007;
        for (int i = 0; i < A.length; i++) {
            res = (res + map.getOrDefault(target - A[i], 0)) % mod;

            for (int j = 0; j < i; j++) {
                int temp = A[i] + A[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        return res;
    }
    
}
