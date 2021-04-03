import java.util.ArrayList;

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
}
