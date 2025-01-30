import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    public static void main(String args[]) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(new int[][]{{1, 4}, {0, 2}, {3, 5}});
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i, j) -> Integer.compare(i[0], j[0]));

        ArrayList<int[]> toReturn = new ArrayList<>();

        boolean mergedLast = false;
        for (int i = 0; i < intervals.length - 1; i++) {
            int endInterval = intervals[i][1];
            int from = i;
            while (from < intervals.length - 1 && endInterval >= intervals[from + 1][0]) {
                endInterval = Math.max(endInterval, intervals[from + 1][1]);
                
                if (from == intervals.length - 2) {
                    mergedLast = true;
                }
                from++;
            }
            toReturn.add(new int[]{intervals[i][0], endInterval});
            i = from;
        }
        if (!mergedLast) {
            toReturn.add(intervals[intervals.length - 1]);
        }

        return toReturn.toArray(new int[toReturn.size()][]);
    }
}
