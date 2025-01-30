//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such 
// that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSumsToZero {
    
    public static void main(String args[]) {
        ThreeSumsToZero threeSumsToZero = new ThreeSumsToZero();
        threeSumsToZero.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
    

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        ArrayList<List<Integer>> toReturn = new ArrayList<>();

        for(int i=0;i< nums.length;i++) {
            if (i == 0 || nums[i-1] != nums[i]) {
                twoSum(nums, i, toReturn);
            }
        }

        return toReturn;
    }

    void twoSum(int[] nums, int i, List<List<Integer>> toReturn) {
        

        HashSet<Integer> seen = new HashSet<>();
        for (int j=i+1;j< nums.length; j++) {
            int target = -nums[i] - nums[j];
            if (seen.contains(target)) {
                toReturn.add(Arrays.asList(nums[i], nums[j], target));
                while (j +1 < nums.length && nums[j] == nums[j+1]) {
                    j++; // skip duplicates
                }
            }
            seen.add(nums[j]);
        }
    }
    
}
