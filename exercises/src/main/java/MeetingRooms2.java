import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    public static void main(String args[]) {
        MeetingRooms2 meetingRooms2 = new MeetingRooms2();
//        meetingRooms2.minMeetingRooms(new int[][]{{9, 10}, {4, 9}, {4, 17}});
        meetingRooms2.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}});
    }

    public int minMeetingRooms(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (i, j) -> Integer.compare(i[0], j[0]));

        PriorityQueue<int[]> endingTimes = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i = 0; i < intervals.length; i++) {
            // if the next meeting ends before the next one start then we have an overlap
            if (endingTimes.isEmpty()) {
                count++; // no room possible to free up
            } else if (endingTimes.peek()[1] > intervals[i][0]) {
                // even the earliest ending meeting hasn't ended before we start
                count++;
            } else {
                // an earlier meeting has ended so we can reuse that room
                endingTimes.poll();
            }
            
            endingTimes.add(intervals[i]);
        }

        return count;
    }


}
