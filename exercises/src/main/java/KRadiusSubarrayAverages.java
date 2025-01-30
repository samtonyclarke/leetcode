public class KRadiusSubarrayAverages {
    public static void main(String args[]) {
        KRadiusSubarrayAverages kRadiusSubarrayAverages = new KRadiusSubarrayAverages();
//        kRadiusSubarrayAverages.getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3);
//        kRadiusSubarrayAverages.getAverages(new int[]{100000}, 0);
        kRadiusSubarrayAverages.getAverages(new int[]{8}, 100000);
    }

    public int[] getAverages(int[] nums, int k) {
        int divideBy = (k * 2) + 1;
        int averages[] = new int[nums.length];
        long runningSums[] = new long[nums.length];
        runningSums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            runningSums[i] = runningSums[i - 1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < k || i >= (nums.length - k)) {
                averages[i] = -1;
            } else {
                long toSubtract = 0;
                if (i > k) {
                    toSubtract = runningSums[i - k - 1];
                }
                long sum = runningSums[i + k] - toSubtract;
                averages[i] = (int) (sum / divideBy);
            }
        }

        return averages;
    }
}
