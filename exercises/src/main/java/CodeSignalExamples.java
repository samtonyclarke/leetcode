public class CodeSignalExamples {

    public static void main(String args[]) {
        CodeSignalExamples codeSignalExamples = new CodeSignalExamples();
        codeSignalExamples.module1(new int[]{4, 0, 1, -2, 3});
    }

    // Given an array a, your task is to output an array b of the same length by applying the following transformation:
    //        • For each i from 0 to a.length - 1 inclusive, b[i] = a[i - 1] + a[i] + a[i + 1]
    //        • If an element in the sum a[i - 1] + a[i] + a[i + 1] does not exist, use 0 in its place
    //• For instance, b[0] = 0 + a[0] + a[1]

    int[] module1(int[] nums) {
        int toReturn[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int first = -1;
            int second = nums[i];
            int third = -1;
            
            if(i == 0) {
                first = 0;
            } else {
                first = nums[i-1];
            }
            if (i == nums.length-1) {
                third = 0;
            } else {
                third = nums[i+1];
            }
            toReturn[i] = first + second + third;
        }

        return toReturn;
    }

}
