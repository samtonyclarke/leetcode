public class MaxConsecutiveOnes {
    public static void main(String args[]) {
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
//        maxConsecutiveOnes.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
//        maxConsecutiveOnes.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3);
//        maxConsecutiveOnes.longestOnes(new int[]{0, 0, 0, 1}, 4);
        int i = maxConsecutiveOnes.longestOnes(new int[]{1, 0, 0, 0}, 2);
        System.out.println(i);
    }

    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int left = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            if ((right - left + 1) > max) {
                max = right - left + 1;
            }
        }

        return max;
    }


}
