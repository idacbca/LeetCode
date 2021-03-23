import java.util.Arrays;
import java.util.Comparator;

public class No435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1 || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int nonOverlap = 1;
        int iEnd = intervals[0][1];
        for (int[] pair : intervals) {
            if (pair[0] >= iEnd) {
                nonOverlap ++;
                iEnd = pair[1];
            }
        }
        return intervals.length - nonOverlap;
    }

    /* Lambda */
    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 1 || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int nonOverlap = 1;
        int iEnd = intervals[0][1];
        for (int[] pair : intervals) {
            if (pair[0] >= iEnd) {
                nonOverlap ++;
                iEnd = pair[1];
            }
        }
        return intervals.length - nonOverlap;
    }
}
