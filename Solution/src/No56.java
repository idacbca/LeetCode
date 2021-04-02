import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class No56 {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> al = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<>(){
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return b[1] - a[1];
                return a[0] - b[0];
            }
        });
        int[] intv = intervals[0];
        int index = 0;
        al.add(intv);
        for (int i = 1; i < intervals.length; i ++) {
            intv = intervals[i];
            int[] lastIntv = al.get(index);
            if (intv[0] <= lastIntv[1]) {
                if (intv[1] > lastIntv[1]) {
                    al.set(index, new int[]{lastIntv[0], intv[1]});
                }
            } else {
                al.add(intv);
                index ++;
            }
        }
        int[][] res = new int[al.size()][];
        return al.toArray(res);
    }
}
