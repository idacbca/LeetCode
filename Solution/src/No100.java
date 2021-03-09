public class No100 {
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

    boolean isSame = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        traverse(p, q);
        return isSame;
    }

    private void traverse(TreeNode p, TreeNode q) {
        if (p == null && q == null) return;
        if (p == null || q == null) {
            isSame = false;
            return;
        }

        TreeNode nodeP = p, NodeQ = q;
        if (p.val != q.val) isSame = false;

        traverse(p.left, q.left);
        traverse(p.right, q.right);
    }
}
