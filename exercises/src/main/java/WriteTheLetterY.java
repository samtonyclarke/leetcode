public class WriteTheLetterY {

    public static void main(String args[]) {

        WriteTheLetterY writeTheLetterY = new WriteTheLetterY();
        writeTheLetterY.minimumOperationsToWriteY(new int[][]{{1, 2, 2}, {1, 1, 0}, {0, 1, 0}});

    }


    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int[] YCountOf = new int[3]; // Frequency of values in Y cells
        int[] notYCountOf = new int[3]; // Frequency of values in not-Y cells

        // Identify Y and not-Y cells
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (isPartOfY(row, col, n)) {
                    YCountOf[grid[row][col]]++;
                } else {
                    notYCountOf[grid[row][col]]++;
                }
            }
        }

        // Calculate minimum operations
        int minOperations = Integer.MAX_VALUE;

        for (int targetYValue = 0; targetYValue < 3; targetYValue++) {
            for (int targetNotYValue = 0; targetNotYValue < 3; targetNotYValue++) {
                if (targetYValue == targetNotYValue) continue; // ensure y and notY values are distinct

                int operationsForY = 0;
                int operationsForNotY = 0;

                // Calculate operations for Y cells
                for (int option = 0; option < 3; option++) {
                    if (option != targetYValue) { // only consider it if it's different from the target
                        operationsForY += YCountOf[option]; // add up the ones that don't match the target
                    }
                }

                // Calculate operations for not-Y cells
                for (int value = 0; value < 3; value++) {
                    if (value != targetNotYValue) { // only consider it if it's different from the target
                        operationsForNotY += notYCountOf[value]; // add up the ones that don't match the target
                    }
                }

                minOperations = Math.min(minOperations, operationsForY + operationsForNotY);
            }
        }

        return minOperations;
    }

    // Determine if a cell belongs to the "Y"
    private boolean isPartOfY(int i, int j, int n) {
        boolean leftDiagonal = (i == j && i <= n / 2);
        boolean verticalLine = (j == n / 2 && i >= n / 2);
        boolean rightDiagonal = (i + j == n - 1 && i <= n / 2);
        return leftDiagonal || verticalLine || rightDiagonal;
    }
}
