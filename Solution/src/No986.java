import java.util.ArrayList;
import java.util.List;

public class No986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) return new int[][]{};
        int i = 0, j = 0;
        ArrayList<int[]> intersect = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int fStart = firstList[i][0], fEnd = firstList[i][1];
            int sStart = secondList[j][0], sEnd = secondList[j][1];
            if (fEnd < sStart) {
                i ++;
                continue;
            } else if (fStart > sEnd) {
                j ++;
                continue;
            }
            int L = Math.max(fStart, sStart);
            int R = Math.min(fEnd, sEnd);
            intersect.add(new int[]{L, R});
            if (fEnd < sEnd) {
                i ++;
            } else {
                j ++;
            }
        }
        int[][] res = new int[intersect.size()][];
        return intersect.toArray(res);
    }

    public int[][] intervalIntersection2(int[][] firstList, int[][] secondList) {
        int p1 = 0, p2 = 0;
        List<int[]> ret = new ArrayList<>();
        while (p1 < firstList.length && p2 < secondList.length) {
            if (firstList[p1][0] <= secondList[p2][1] && secondList[p2][0] <= firstList[p1][1]) {
                int[] intersection = new int[2];
                intersection[0] = Math.max(firstList[p1][0], secondList[p2][0]);
                intersection[1] = Math.min(firstList[p1][1], secondList[p2][1]);
                ret.add(intersection);
            }
            if (firstList[p1][1] < secondList[p2][1]) {
                p1++;
            } else {
                p2++;
            }
        }
        return ret.toArray(new int[ret.size()][2]);
    }
}
