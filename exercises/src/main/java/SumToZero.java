import java.util.*;


public class SumToZero {
    
    public static void main(String args[]) {
        SumToZero sumToZero = new SumToZero();
        sumToZero.findChocPairs(new int[]{4, 3, -5, 5, -3, -4});
    }
    
    public List<int[]> findChocPairs(int[] sweetness) {
        List<int[]> toReturn = new ArrayList<>();

        System.out.println("Input is: "+ Arrays.toString(sweetness));

        Arrays.sort(sweetness);
        int left = 0;
        int right = sweetness.length -1;

        while(left<right) {
            if(sweetness[left] + sweetness[right] == 0){
                toReturn.add(new int[]{sweetness[right], sweetness[left]});
                left++;
                right--;
            } else if (sweetness[left] + sweetness[right] > 0) {
                right--;
            } else {
                left++;
            }
        }
        toReturn.sort(Comparator.comparingInt(a -> a[0]));
        return toReturn;
    }
}
