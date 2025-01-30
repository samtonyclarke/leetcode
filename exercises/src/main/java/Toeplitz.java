public class Toeplitz {
    public static void main(String args[]) {
        Toeplitz toeplitz = new Toeplitz();
//        toeplitz.isToeplitzMatrix(new int[][]{{1, 2, 3}, {2, 3, 4}, {4, 2, 3}});

        toeplitz.isToeplitzMatrix(new int[][]{{6, 7, 8}, {4, 6, 7}, {1, 4, 6}});

        // 1 2 3
        // 2 3 4
        // 4 2 3
    }
    //  diagonal (from left to right) 

    public boolean isToeplitzMatrix(int[][] matrix) {

        int n = matrix[0].length;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (x<n-1 && y<n-1) {
                    if(matrix[y][x] != matrix[y+1][x+1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
