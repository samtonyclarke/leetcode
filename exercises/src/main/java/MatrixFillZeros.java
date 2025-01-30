import java.util.*;

public class MatrixFillZeros {

    // Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
    
    public static void main(String args[]) {
        MatrixFillZeros matrixFillZeros = new MatrixFillZeros();
        matrixFillZeros.setZeroes(new int[][]{{1, 1, 1}, {1,0,1}, {1,1,1}});
    }
    
    public void setZeroes(int[][] matrix) {
        

        boolean fillFirstColumn = false;
        boolean fillFirstRow = false;

        for(int y=0;y<matrix.length;y++) {
            if (matrix[y][0] == 0) {
                fillFirstColumn = true;
            }
        }

        for (int x=1;x<matrix[0].length;x++) {
            if (matrix[0][x] == 0) {
                fillFirstRow = true;
            }
        }
        
        for(int y=0;y<matrix.length;y++) {
            for (int x=1;x<matrix[0].length;x++) {
                if (matrix[y][x] == 0) {
                    matrix[y][0] = 0;
                    matrix[0][x] = 0;
                }
            }
        }

        // second pass use prior marking to apply zeros
        for(int y=1;y<matrix.length;y++) {
            for (int x=1;x<matrix[0].length;x++) {
                if(matrix[y][0] == 0 || matrix[0][x] == 0) {
                    matrix[y][x] = 0;
                }
            }
        }
        if (fillFirstColumn) {
            System.out.println("Fill first column is true");
            for(int y=0;y<matrix.length;y++) {
                matrix[y][0] = 0;
            }
        }
        if (fillFirstRow) {
            System.out.println("Fill first row is true");
            for(int x=0;x<matrix[0].length;x++) {
                matrix[0][x] = 0;
            }
        }

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        map.values();
    }
    
}
