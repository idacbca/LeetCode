import java.util.HashSet;
import java.util.Set;

public class No653 {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> values = new HashSet<>();
        return check(root, k, values);
    }

    private boolean check(TreeNode root, int k, Set<Integer> values) {
        if (root == null) {
            return false;
        }
        if (values.contains(k - root.val)) {
            return true;
        }
        values.add(root.val);
        return check(root.left, k, values) || check(root.right, k, values);
    }
}
