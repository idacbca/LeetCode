public class No230 {
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

    int rank;
    int res;

    public int kthSmallest(TreeNode root, int k) {
        rank = 0;
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        rank ++;
        if (rank == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
