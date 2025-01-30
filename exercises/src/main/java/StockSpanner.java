import java.util.Stack;

public class StockSpanner {
    
    public static void main(String args[]) {
//        StockSpanner stockSpanner = new StockSpanner();
//        stockSpanner.next(50);
//        stockSpanner.next(45);
//        stockSpanner.next(40);
//        stockSpanner.next(35);
//        stockSpanner.next(30);

        StockSpanner stockSpanner2 = new StockSpanner();
        stockSpanner2.next(100);
        stockSpanner2.next(80);
        stockSpanner2.next(60);
        stockSpanner2.next(70);
        stockSpanner2.next(60);
        stockSpanner2.next(75);
        stockSpanner2.next(85);
    }

    Stack<int[]> stack = new Stack<>();

    public int next(int price) {
        int ans = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            ans += stack.pop()[1];
        }

        stack.push(new int[] {price, ans});
        return ans;
    }
    
}
