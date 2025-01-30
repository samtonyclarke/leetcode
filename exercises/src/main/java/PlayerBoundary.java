public class PlayerBoundary {

    public static void main(String args[]) {
        PlayerBoundary playerBoundary = new PlayerBoundary();
        playerBoundary.evaluatePath(new int[]{2, 1, -3, -4});
        
    }
    
    public int[] evaluatePath(int[] numbers) {
        int moveCount = 0;
        int boundaryExceedCount = 0;
        int position = 0;
        int direction = 1;

        while (boundaryExceedCount < 2 && numbers[position] != 0) {

            int nextPosition = position + (numbers[position] * direction);

            if (nextPosition < 0 || nextPosition >= numbers.length) {
                boundaryExceedCount++;
                direction = -direction; // Reverse direction
            } else {
                position = nextPosition;
                moveCount++;
            }
        }

        return new int[] {position, moveCount};
    }
    
}
