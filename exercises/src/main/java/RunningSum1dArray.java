public class RunningSum1dArray {
    public static void main(String args[]) {
        RunningSum1dArray runningSum1dArray = new RunningSum1dArray();
        runningSum1dArray.runningSum(new int[]{1,2,3,4});
    }

    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        
        runningSum[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            runningSum[i] = runningSum[i-1] + nums[i];
        }
        
        return runningSum;
    }
}
