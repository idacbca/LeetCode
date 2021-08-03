public class No701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode ptr = root;
        while (ptr != null) {
            if (val < ptr.val) {
                if (ptr.left == null) {
                    ptr.left = new TreeNode(val);
                    break;
                } else {
                    ptr = ptr.left;
                }
            } else {
                if (ptr.right == null) {
                    ptr.right = new TreeNode(val);
                    break;
                } else {
                    ptr = ptr.right;
                }
            }
        }
        return root;
    }
}
