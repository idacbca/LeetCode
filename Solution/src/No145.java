import java.util.List;
import java.util.LinkedList;

public class No145 {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        traverse(root, res);
        return res;
    }

    private void traverse(TreeNode root, List res) {
        if (root == null) return;
        traverse(root.left, res);
        traverse(root.right, res);

        res.add(root.val);
    }
}
