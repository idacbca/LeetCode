public class No783 {
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

    TreeNode pre;
    int res;

    public int minDiffInBST(TreeNode root) {
        pre = null;
        res = Integer.MAX_VALUE;
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        if (pre != null) {
            res = Math.min(res, root.val - pre.val);
        }
        pre = root;
        traverse(root.right);
    }
}
