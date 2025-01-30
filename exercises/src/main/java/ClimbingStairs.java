public class ClimbingStairs {

    
    public static void main(String args[]) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        climbingStairs.climbStairs(4);
    }
    
    public int climbStairs(int n) {

        return climbStairsHelper(n, 0);
    }

    private int climbStairsHelper(int n, int stepNumber) {
        if (stepNumber > n) {
            return 0;
        }

        if (stepNumber == n) {
            return 1;
        }

        return climbStairsHelper(n, stepNumber + 1) + climbStairsHelper(n, stepNumber + 2);
    }
}
