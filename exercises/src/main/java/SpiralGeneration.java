

public class SpiralGeneration {
    
    public static void main(String args[]) {
        SpiralGeneration spiralGeneration = new SpiralGeneration();
        
        spiralGeneration.generateMatrix(3);
//        spiralGeneration.generateMatrix(1);
        
    }

    public int[][] generateMatrix(int n) {
        int[][] toReturn = new int[n][n];

        if (n == 1) {
            toReturn[0][0] = 1;  // Fix index error
            return toReturn;
        }

        int count = 0;
        int row = 0, col = 0;
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (count < n * n) {

            // Go right
            while (col <= right) {
                toReturn[row][col] = count++ + 1;
                col++;
            }
            col--;
            row++;
            top++;

            // Go down
            while (row <= bottom) {
                toReturn[row][col] = count++ + 1;
                row++;
            }
            row--;
            col--;
            right--;

            // Go left
            while (col >= left) {
                toReturn[row][col] = count++ + 1;
                col--;
            }
            col++;
            row--;
            bottom--;

            // Go up
            while (row >= top) {
                toReturn[row][col] = count++ + 1;
                row--;
            }
            row++;
            col++;
            left++;
        }

        return toReturn;
    }
    
}
