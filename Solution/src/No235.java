import java.util.ArrayList;
import java.util.List;

public class No235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = getPath(root, p);
        List<TreeNode> qPath = getPath(root, q);
        TreeNode ret = root;
        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
            if (pPath.get(i) == qPath.get(i)) {
                ret = pPath.get(i);
            }
        }
        return ret;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode node) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode ptr = root;
        while (ptr != node) {
            path.add(ptr);
            if (ptr.val > node.val) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }
        path.add(ptr);
        return path;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ret = root;
        TreeNode ptr = root;
        while (true) {
            if (ptr.val < p.val && ptr.val < q.val) {
                ptr = ptr.right;
            } else if (ptr.val > p.val && ptr.val > q.val) {
                ptr = ptr.left;
            } else {
                ret = ptr;
                break;
            }
        }
        return ret;
    }
}
