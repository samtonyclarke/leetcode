import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SpaceJump {
    
    public static void main(String args[]) {
        SpaceJump spaceJump = new SpaceJump();
        spaceJump.solution(new int[]{1, 3, 2, 5, 4}, new int[]{5, 4, 3, 2, 1});
    }
    
    public List<Integer> solution(int[] arrayA, int[] arrayB) {
        // TODO: Implement the function

        ArrayList<Integer> visitedInB = new ArrayList();
        HashSet<Integer> alreadyVisitedInA = new HashSet();
        int currentValue = arrayA[0];
        while(true) {
            if(alreadyVisitedInA.contains(currentValue)) {
                break;
            }
            alreadyVisitedInA.add(currentValue);
            int bValue = arrayB[currentValue-1];
            visitedInB.add(currentValue);
            currentValue = arrayA[bValue-1];
        }

        return visitedInB;
    }
}
