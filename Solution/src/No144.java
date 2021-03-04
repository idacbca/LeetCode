import java.util.LinkedList;
import java.util.List;

public class No144 {
     //Definition for a binary tree node.
    public class TreeNode {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrderList = new LinkedList<>();
        if (root == null) return preOrderList;
        traversal(root, preOrderList);
        return preOrderList;
    }

    private void traversal(TreeNode root, List<Integer> preOrderList) {
        if (root == null) return;
        preOrderList.add(root.val);
        traversal(root.left, preOrderList);
        traversal(root.right, preOrderList);
    }
}
