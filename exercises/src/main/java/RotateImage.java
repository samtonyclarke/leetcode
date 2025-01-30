import java.util.Arrays;
import java.util.stream.Collectors;

public class RotateImage {

    public static void main(String args[]) {
        RotateImage rotateImage = new RotateImage();
//        rotateImage.reverseMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        rotateImage.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        for (int y = 0; y < n / 2; y++) { // Layer by layer
            int lastRow = n - y - 1; // Index of the last row in the current layer
            for (int x = y; x < lastRow; x++) { // Elements in the current layer
                int lastCol = n - x - 1; // Index of the last column in the current layer

                // Perform the 4-way swap
                int temp = matrix[y][x]; // Top element
                matrix[y][x] = matrix[lastCol][y];       // Left -> Top
                matrix[lastCol][y] = matrix[lastRow][lastCol]; // Bottom -> Left
                matrix[lastRow][lastCol] = matrix[x][lastRow]; // Right -> Bottom
                matrix[x][lastRow] = temp;               // Top -> Right
            }
        }
    }

    public void rotateViaTransformations(int[][] matrix) {
        transposeNxN(matrix);
        reverseMatrix(matrix);
    }

    public void transposeNxN(int[][] matrix) {
        for(int y=0;y<matrix.length;y++) {
            for(int x=y;x<matrix[0].length;x++) {
                int temp = matrix[y][x];
                matrix[y][x] = matrix[x][y];
                matrix[x][y] = temp;
            }
        }
        
//        int n = matrix.length;
//        for (int x = 0; x < n; x++) {
//            for (int y = x; y < n; y++) {
//                int temp = matrix[y][x];
//                matrix[y][x] = matrix[x][y];
//                matrix[x][y] = temp;
//            }
//        }
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        

        return prefix.toString();

    }
    
    public void reverseMatrix(int[][] matrix) {
        int n = matrix[0].length;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n / 2; x++) {
                int temp = matrix[y][x];
                matrix[y][x] = matrix[y][n - x - 1];
                matrix[y][n - x - 1] = temp;
            }
        }
    }

}
