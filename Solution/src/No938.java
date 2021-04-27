public class No938 {
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

    public int rangeSumBST(TreeNode root, int low, int high) {
        return traverse(root, low, high);
    }

    private int traverse(TreeNode root, int low, int high) {
        if (root == null) return 0;

        if (root.val < low) {
            return traverse(root.right, low, high);
        }
        if (root.val > high) {
            return traverse(root.left, low, high);
        }

        return root.val + traverse(root.left, low, high) + traverse(root.right, low, high);
    }
}
