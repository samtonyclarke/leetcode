import java.util.HashMap;

public class MinCostClimbingStairs {

    HashMap<Integer, Integer> savedCalcs = new HashMap<>();

    public static void main(String args[]) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        System.out.println("Min cost is: " +
                minCostClimbingStairs.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public int minCostClimbingStairs(int[] cost) {

        int fromFirstStep = minCostClimbingStairsHelper(cost, 0);
        int fromSecondStep = minCostClimbingStairsHelper(cost, 1);
        return Math.min(fromFirstStep, fromSecondStep);
    }

    private int minCostClimbingStairsHelper(int[] cost, int landingStep) {
        if (landingStep >= cost.length) {
            return 0;
        }

        if (landingStep == cost.length - 1) {
            return cost[cost.length - 1];
        }

        if (savedCalcs.containsKey(landingStep)) {
            return savedCalcs.get(landingStep);
        }


        int twoStep = cost[landingStep] + minCostClimbingStairsHelper(cost, landingStep + 2);
        int oneStep = cost[landingStep] + minCostClimbingStairsHelper(cost, landingStep + 1);
        int minCost = Math.min(oneStep, twoStep);
        savedCalcs.put(landingStep, minCost);
        return minCost;
    }

}
