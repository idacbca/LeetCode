public class No875 {
    public int minEatingSpeed(int[] piles, int h) {
        int right = getMax(piles) + 1;
        int left = 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEat(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getMax(int[] piles) {
        int res = piles[0];
        for (int i : piles) {
            res = Math.max(i, res);
        }
        return res;
    }

    private boolean canEat(int[] piles, int h, int speed) {
        int res = 0;
        for (int i : piles) {
            res += i % speed == 0 ? i / speed : i / speed + 1;
        }
        return res <= h;
    }
}
