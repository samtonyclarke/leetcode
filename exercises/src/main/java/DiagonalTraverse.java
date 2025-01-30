import java.util.ArrayList;

public class DiagonalTraverse {

    public static void main(String args[]) {
        DiagonalTraverse diagonalTraverse = new DiagonalTraverse();
//        diagonalTraverse.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        diagonalTraverse.findDiagonalOrder(new int[][]{{1, 2}, {3, 4}});
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int width = mat[0].length;
        int height = mat.length;
        int total = width * height;

        int x = 0;
        int y = 0;
        int xDirection = 1;
        int yDirection = -1;
        ArrayList<Integer> walked = new ArrayList<>();

        while (walked.size() < total) {
            int direction = outsideBoundary(x, y, mat);
            if (direction == 1) {
                y += 2;
                x -= 1;
                xDirection = xDirection * -1;
                yDirection = yDirection * -1;
                continue;
            } else if (direction == 2) {
                y += 1;
                xDirection = xDirection * -1;
                yDirection = yDirection * -1;
                continue;
            } else if (direction == -1) {
                x += 1;
                xDirection = xDirection * -1;
                yDirection = yDirection * -1;
                continue;
            } else if (direction == -2) {
                x += 2;
                y -= 1;
                xDirection = xDirection * -1;
                yDirection = yDirection * -1;
                continue;
            } else {
                walked.add(mat[y][x]);
            }
            x += xDirection;
            y += yDirection;
        }


        return walked.stream().mapToInt(i -> i).toArray();
    }

    int outsideBoundary(int x, int y, int[][] mat) {
        // gone over right side
        if (x > mat[0].length - 1) {
            return 1;
        }
        // gone over top side
        if (y < 0) {
            return 2;
        }
        // gone over bottom side
        if (y > mat.length - 1) {
            return -2;
        }
        // gone over left side
        if (x < 0) {
            return -1;
        }

        return 0;
    }




}
