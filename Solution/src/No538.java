public class No538 {
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

    /* Recursive reverse traversal */
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        return traverse(root);
    }

    private TreeNode traverse(TreeNode root) {
        if (root == null) return null;
        root.right = traverse(root.right);
        sum += root.val;
        root.val = sum;
        root.left = traverse(root.left);
        return root;
    }

    /* Morris */
    public TreeNode convertBST2(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        while (node != null) {
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            } else {
                TreeNode succ = findSuccessor(node);
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                } else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }
        return root;
    }

    private TreeNode findSuccessor(TreeNode root) {
        TreeNode succ = root.right;
        while (succ.left != root && succ.left != null) {
            succ = succ.left;
        }
        return succ;
    }
}
