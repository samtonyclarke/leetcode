import java.util.HashMap;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{2}, 3)); // Expected output: -1
    }

    private HashMap<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        memo.put(0, 0); // Base case: 0 coins needed for amount 0
        int result = coinChangeHelper(coins, amount);
        if (result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }

    private int coinChangeHelper(int[] coins, int amount) {
        if (amount < 0) {
            return Integer.MAX_VALUE; // No solution for negative amounts
        }
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeHelper(coins, amount - coin);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + res);
            }
        }
        memo.put(amount, min);
        return min;
    }
}
