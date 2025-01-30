public class TransposeMatrix {
    
    public static void main(String args[]) {
        TransposeMatrix transposeMatrix = new TransposeMatrix();
        //transposeMatrix.transpose(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        transposeMatrix.transpose(new int[][]{{1,2,3},{4,5,6}});
    }

    public int[][] transpose(int[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;
        
        if (width == height) {
            return transposeNxN(matrix);
        }
        int[][] toReturn = new int[width][height];
        for(int y=0;y<height;y++) {
            for(int x=0;x<width;x++){
                toReturn[x][y] = matrix[y][x];
            }
        }
        
        return toReturn;
    }

    public int[][] transposeNxN(int[][] matrix) {
        int n = matrix.length;
        for(int x=0;x<n;x++) {
            for(int y=x;y<n;y++) {
                int temp = matrix[y][x];
                matrix[y][x] = matrix[x][y];
                matrix[x][y] = temp;
            }
        }

        return matrix;
    }
    
    
}
