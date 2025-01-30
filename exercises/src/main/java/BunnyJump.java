import java.util.HashSet;

public class BunnyJump {
    public static void main(String args[]) {
        BunnyJump bunnyJump = new BunnyJump();
        bunnyJump.solution(new int[]{2, 1, 3, 0}, new int[]{1, 3, 2, 4}, new int[]{4, 2, 5, 1});
    }

    public int solution(int[] arrayA, int[] arrayB, int[] arrayC) {
        // TODO: implement
        int maxB = 0;
        int maxC = 0;
        int aIndex = 0;
        int bIndex = 0;
        int cIndex = 0;
        boolean gotoB = true;
        HashSet<String> pathsVisited = new HashSet();

        while (true) {
            if (aIndex >= arrayA.length) {
                break;
            }
            if (gotoB) {
                bIndex = arrayA[aIndex];
                if (bIndex >= arrayB.length) {
                    break;
                }
                if (arrayB[bIndex] > maxB) {
                    maxB = arrayB[bIndex];
                }
                aIndex = arrayB[bIndex];
                gotoB = false;
            } else if (!gotoB) {
                cIndex = arrayA[aIndex];
                if (cIndex >= arrayC.length) {
                    break;
                }
                if (arrayC[cIndex] > maxC) {
                    maxC = arrayC[cIndex];
                }
                aIndex = arrayC[cIndex];
                gotoB = true;
            }
            String path = aIndex + "," + (gotoB ? "B" : "C");
            if (pathsVisited.contains(path)) {
                break;
            }
            pathsVisited.add(path);
        }
        return maxB + maxC;
    }

}
