public class AlternatingSubArrays {

    public static void main(String args[]) {
        AlternatingSubArrays alternatingSubArrays = new AlternatingSubArrays();
//        alternatingSubArrays.countAlternatingSubarrays(new int[]{0,1,1,1});
        alternatingSubArrays.countAlternatingSubarrays(new int[]{1,0,1,0});
    }

    public long countAlternatingSubarrays(int[] nums) {
        long count = 0;
        long length = 0;
        int start = 0;
        int end = 1;
        while(end < nums.length) {
            if(nums[end] != nums[end - 1]) {
                end++;
            } else {
                length = end - start;
                count += (length * (length + 1)) / 2; // formula to count sum to n, 1+2+3 = 3*4 /2 = 6 
                start = end;
                end++;
            }
        }
        length = end - start;
        count += (length * (length + 1)) / 2; // formula to count sum to n, 1+2+3 = 3*4 /2 = 6
        return count;
    }


    
}
