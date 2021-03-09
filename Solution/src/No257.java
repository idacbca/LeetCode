import java.util.LinkedList;
import java.util.List;

public class No257 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        traverse(root, "", res);
        return res;
    }

    private void traverse(TreeNode root, String path, List res) {
        if (root == null) {
            return;
        }

        StringBuilder sb = new StringBuilder(path);
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            traverse(root.left, sb.toString(), res);
            traverse(root.right, sb.toString(), res);
        }
    }
}
