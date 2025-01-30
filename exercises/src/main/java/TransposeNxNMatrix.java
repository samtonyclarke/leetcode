public class TransposeNxNMatrix {
    
    public static void main(String args[]) {
        TransposeNxNMatrix transposeMatrix = new TransposeNxNMatrix();
        transposeMatrix.transpose(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

    public int[][] transpose(int[][] matrix) {
        // since it's n x n we can do it in place
         
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
