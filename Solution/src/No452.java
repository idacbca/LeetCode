import java.util.Arrays;
import java.util.Comparator;

public class No452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        if (points.length == 1) return 1;
        Arrays.sort(points, new Comparator<>() {
            public int compare(int[] a, int[] b) {
                if (a[1] > b[1]) {
                    return 1;
                } else if (a[1] < b[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int count = 1;
        int xEnd = points[0][1];
        for (int[] point : points) {
            if (point[0] > xEnd) {
                xEnd = point[1];
                count ++;
            }
        }
        return count;
    }
}
