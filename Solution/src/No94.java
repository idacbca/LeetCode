import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No94 {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrderList = new LinkedList<>();
        Deque<TreeNode> stk = new LinkedList<>();

        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            inOrderList.add(root.val);
            root = root.right;
        }

        return inOrderList;
    }
}
