public class LongestSubarrayOf1sAfterDeletingOneElement {

    public static void main(String args[]) {
        LongestSubarrayOf1sAfterDeletingOneElement longestSubarrayOf1sAfterDeletingOneElement =
                new LongestSubarrayOf1sAfterDeletingOneElement();
//        int length = longestSubarrayOf1sAfterDeletingOneElement.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1});
        int length = longestSubarrayOf1sAfterDeletingOneElement.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1});
        System.out.println(length);
    }

    public int longestSubarray(int[] nums) {
        int left = 0;
        int maxLength = 0;
        int zeroCount = 0;

        int right = 0;  // Initialize the `right` pointer

        while (right < nums.length) {
            if (nums[right] == 0) {
                while(zeroCount>0) {
                    if(nums[left++]==0) {
                        zeroCount--;
                    }
                }
                zeroCount++;
            }

            // Calculate the length of the current window (valid subarray)
            maxLength = Math.max(maxLength, right - left);

            right++;  // Move `right` to expand the window
        }

        return maxLength;
    }

}
