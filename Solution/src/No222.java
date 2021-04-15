public class No222 {
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

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode l = root, r = root;
        int lHight = 0, rHight = 0;

        while (l != null) {
            l = l.left;
            lHight ++;
        }
        while (r != null) {
            r = r.right;
            rHight ++;
        }

        if (lHight == rHight) {
            return (int) Math.pow(2, lHight) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
