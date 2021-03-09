public class No98 {
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

    public boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }

    private boolean check(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null) {
            if (root.val <= min.val) return false;
        }
        if (max != null) {
            if (root.val >= max.val) return false;
        }

        return check(root.left, min, root) && check(root.right, root, max);
    }
}
