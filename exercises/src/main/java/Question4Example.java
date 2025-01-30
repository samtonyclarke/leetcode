import java.util.*;

public class Question4Example {

//    Given an array of unique integers numbers, your task is to find the number of pairs of indices (i, j) 
//    such that i ≤ j and the sum numbers[i] + numbers[j] is equal to some power of 2.
//    Note: The numbers 20  = 1, 21 = 2, 22 = 4, 23 = 8, etc. are considered to be powers of 2.


    public static void main(String args[]) {
        Question4Example question4Example = new Question4Example();
        question4Example.powerOffTwo(new int[]{1, -1, 2, 3});
    }


//    int powerOffTwo(int nums[]) {
//        Map<Integer, Integer> counts = new HashMap<>(); // Map to count occurrences of numbers
//        int answer = 0;
//
//        for (int element : nums) {
//            counts.put(element, counts.getOrDefault(element, 0) + 1);
//
//            // Check for sums equal to powers of 2 (up to 2^21)
//            for (int twoPower = 0; twoPower < 5; twoPower++) {
//                int target = (1 << twoPower) - element; // The second element needed for the sum
//
//                // Add the count of target (if it exists in the map so far)
//                answer += counts.getOrDefault(target, 0);
//            }
//        }
//        return answer;
//        
//    }    

    int powerOffTwo(int nums[]) {
        int count = 0;
        ArrayList<Integer> powersOfTwos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            powersOfTwos.add(1 << i);
        }

        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            seen.add(nums[i]);
            for (Integer powerOfTwo : powersOfTwos) {
                int target = powerOfTwo - nums[i];
                if (seen.contains(target)) {
                    count++;
                }
            }

        }


        return count;
    }


}
