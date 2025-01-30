import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CandyCrush {
    public static void main(String args[]) {
        CandyCrush candyCrush = new CandyCrush();
        candyCrush.candyCrush(new int[][]{{110, 5, 112, 113, 114}, {210, 211, 5, 213, 214}, {310, 311, 3, 313, 314},
                {410, 411, 412, 5, 414}, {5, 1, 512, 3, 3}, {610, 4, 1, 613, 614}, {710, 1, 2, 713, 714},
                {810, 1, 2, 1, 1}, {1, 1, 2, 2, 2}, {4, 1, 4, 4, 1014}});
    }

    public int[][] candyCrush(int[][] board) {
        while (true) {
            Set<List<Integer>> horizontalToCrush = scanHorizontal(board);
            Set<List<Integer>> verticalToCrush = scanVertical(board);
            horizontalToCrush.addAll(verticalToCrush);
            if (horizontalToCrush.isEmpty()) {
                break;
            }
            markAsEmpty(horizontalToCrush, board);
            pullDown(board);
        }

        return board;
    }

//
//    private void collapsev1(int[][] board) {
//        for (int row = board.length - 1; row > 0; row--) {
//            for (int col = 0; col < board[0].length; col++) {
//                if (board[row][col] == 0) {
//                    pullDown(board, row, col);
//                }
//            }
//        }
//    }

    void pullDown(int[][] board) {
        for (int col = 0; col < board[0].length; col++) {
            int lowestZero = -1;

            // Iterate over each column
            for (int row = board.length - 1; row >= 0; row--) {
                if (board[row][col] == 0) {
                    lowestZero = Math.max(lowestZero, row);
                } else if (lowestZero >= 0) {
                    int temp = board[row][col];
                    board[row][col] = board[lowestZero][col];
                    board[lowestZero][col] = temp;
                    lowestZero--;
                }
            }
        }
    }


//    private void pullDown(int[][] board, int row, int col) {
//        int from = row;
//        boolean foundNonZero = false;
//        while (from > 0) {
//            board[from][col] = board[from - 1][col];
//            if (board[from][col] != 0) {
//                foundNonZero = true;
//            }
//            from--;
//        }
//        board[0][col] = 0;
//        if(board[row][col] == 0 && foundNonZero) {
//            pullDown(board, row, col);
//        }
//    }

    private void markAsEmpty(Set<List<Integer>> setAsEmpty, int[][] board) {

        for (List<Integer> coords : setAsEmpty) {
            board[coords.get(0)][coords.get(1)] = 0;
        }

    }


    private Set<List<Integer>> scanHorizontal(int[][] board) {
        Set<List<Integer>> toCrush = new HashSet<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length - 2; col++) { // Avoid redundant iterations
                int candy = board[row][col];
                if (candy == 0) { // Skip empty cells
                    continue;
                }

                int match = 1;
                int from = col;

                // Count consecutive matches
                while (from + 1 < board[0].length && board[row][from] == board[row][from + 1]) {
                    match++;
                    from++;
                }

                // If a match is found, add all involved coordinates to the set
                if (match >= 3) {
                    for (int i = col; i <= from; i++) {
                        toCrush.add(Arrays.asList(row, i));
                    }
                }
            }
        }

        return toCrush;
    }


    private Set<List<Integer>> scanVertical(int[][] board) {
        Set<List<Integer>> toCrush = new HashSet<>();

        for (int col = 0; col < board[0].length; col++) {
            for (int row = 0; row < board.length - 2; row++) { // Avoid redundant iterations
                int candy = board[row][col];
                if (candy == 0) { // Skip empty cells
                    continue;
                }

                int match = 1;
                int from = row;

                // Count consecutive matches
                while (from + 1 < board.length && board[from][col] == board[from + 1][col]) {
                    match++;
                    from++;
                }

                // If a match is found, add all involved coordinates to the set
                if (match >= 3) {
                    for (int i = row; i <= from; i++) {
                        toCrush.add(Arrays.asList(i, col));
                    }
                }

            }
        }

        return toCrush;
    }

}
