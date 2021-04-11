import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class No349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> n1 = new HashSet<>();
        Set<Integer> n2 = new HashSet<>();
        for (int num : nums1) {
            n1.add(num);
        }
        for (int num : nums2) {
            n2.add(num);
        }
        return getIntersection(n1, n2);
    }

    private int[] getIntersection(Set<Integer> n1, Set<Integer> n2) {
        if (n1.size() > n2.size()) return getIntersection(n2, n1);
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : n1) {
            if (n2.contains(num)) res.add(num);
        }
        int[] its = new int[res.size()];
        int i = 0;
        for (int num : res) {
            its[i++] = num;
        }
        return its;
    }
}
