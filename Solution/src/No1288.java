import java.util.Arrays;
import java.util.Comparator;

public class No1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] > b[0]) {
                    return 1;
                } else if (a[0] < b[0]) {
                    return -1;
                } else {
                    return b[1] - a[1];
                }
            }
        });
        int intvStart = intervals[0][0];
        int intvEnd = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i ++) {
            int[] intv = intervals[i];
            if (intv[0] == intvStart) {
                res ++;
            } else {
                if (intv[1] <= intvEnd) {
                    res ++;
                } else {
                    intvStart = intv[0];
                    intvEnd = intv[1];
                }
            }
        }
        return intervals.length - res;
    }
}
