public class No1011 {
    public int shipWithinDays(int[] weights, int D) {
        int left = getMax(weights);
        int right = sum(weights) + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getMax(int[] weights) {
        int res = 0;
        for (int i : weights) {
            res = Math.max(res, i);
        }
        return res;
    }

    private int sum(int[] weights) {
        int res = 0;
        for (int i : weights) {
            res += i;
        }
        return res;
    }

    private boolean canFinish(int[] weights, int D, int cap) {
        int i = 0;
        for (int day = 0; day < D; day ++) {
            int maxCap = cap;
            while ((maxCap -= weights[i]) >= 0) {
                i ++;
                if (i == weights.length) return true;
            }
        }
        return false;
    }
}
