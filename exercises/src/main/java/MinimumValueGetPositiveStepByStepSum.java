public class MinimumValueGetPositiveStepByStepSum {
    public static void main(String args[]) {
        MinimumValueGetPositiveStepByStepSum minimumValueGetPositiveStepByStepSum =
                new MinimumValueGetPositiveStepByStepSum();
//        minimumValueGetPositiveStepByStepSum.minStartValue(new int[]{-3, 2, -3, 4, 2});
//        minimumValueGetPositiveStepByStepSum.minStartValue(new int[]{1, 2});
//        minimumValueGetPositiveStepByStepSum.minStartValue(new int[]{1, -2, -3});
        minimumValueGetPositiveStepByStepSum.minStartValue(new int[]{-12});
    }

    public int minStartValue(int[] nums) {
        int runningSum[] = new int[nums.length];
        runningSum[0] = nums[0];
        int startValue = 1;
        if (runningSum[0]<1) {
            int candidate = (runningSum[0] * -1) + 1;
            if (candidate > startValue) {
                startValue = candidate;
            }
        }        
        
        for (int i = 1; i < nums.length; i++) {
            runningSum[i] = runningSum[i-1] + nums[i];
            if (runningSum[i]<1) {
                int candidate = (runningSum[i] * -1) + 1;
                if (candidate > startValue) {
                    startValue = candidate;
                }
            }
        }

        return startValue;
    }
}
