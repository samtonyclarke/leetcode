public class MissingNumber {
    public static void main(String args[]) {
        MissingNumber missingNumber = new MissingNumber();
        missingNumber.missingNumber(new int[]{0,2,3});
    }

    public int missingNumber(int[] nums) {
        int occupied[] = new int[nums.length+1];
        
        for(int i=0;i<nums.length;i++) {
            occupied[nums[i]] = 1;
        }
        for(int i=0;i<occupied.length;i++) {
            if(occupied[i] == 0){
                return i;
            }
        }
        
        return -1;
    }
}
