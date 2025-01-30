public class MaximumAverageSubarray {

    public static void main(String args[]) {
        MaximumAverageSubarray maximumAverageSubarray = new MaximumAverageSubarray();
        maximumAverageSubarray.findMaxAverage(new int[]{5}, 1);
    }

    double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double initialAverage = (double)sum / k;
        double maxAverage = initialAverage;
        
        for (int left = 1; left + k < nums.length + 1; left++) {
            sum-=nums[left-1];
            sum+=nums[left+k-1];
            double average = (double)sum / k;
            if (average > maxAverage) {
                maxAverage = average;
            }
        }

        return maxAverage;
    }
}
