public class AntiRotateArray {
    
    public static void main(String args[]) {
        antiRotateArray(new int[]{1,2,3}, 1);
        
    }

    public static void antiRotateArray(int[] nums, int k) {
        k = k % nums.length;

        rotate(nums,0,k-1);
        rotate(nums,k,nums.length-1);
        rotate(nums,0,nums.length-1);

    }

    public static void rotate(int[] nums, int from, int to) {

        while(from<to) {
            int temp = nums[from];
            nums[from] = nums[to];
            nums[to] = temp;
            from++;
            to--;
        }
    }
    
    
    
}
