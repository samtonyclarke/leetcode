public class MoveZeros {


    public static void main(String args[]) {
        MoveZeros moveZeros = new MoveZeros();
        moveZeros.moveZeroes(new int[]{1, 0, 1, 0, 3, 12});
//        moveZeros.moveZeroes(new int[]{1, 2,3, 4, 5, 6});
//        moveZeros.moveZeroes(new int[]{1, 0,0,0, 4, 5, 6});
    }

    public void moveZeroes(int[] nums) {
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                int temp = nums[cur];
                nums[cur] = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = temp;
                lastNonZeroFoundAt++;
            }
        }
    }
}

