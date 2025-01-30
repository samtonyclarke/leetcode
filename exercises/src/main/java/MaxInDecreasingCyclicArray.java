public class MaxInDecreasingCyclicArray {

    public static void main(String args[]) {
        int[] nums = new int[] {4, 3, 2, 1, 7, 6, 5};
        System.out.println(findMax(nums));  // Output: 7

    }

    public static int findMax(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
    
}
