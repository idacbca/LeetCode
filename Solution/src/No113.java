import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No113 {
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

    List<List<Integer>> res;
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new LinkedList<>();
        traverse(root, targetSum);
        return res;
    }

    private void traverse(TreeNode root, int targetSum) {
        if (root == null) return;

        targetSum -= root.val;
        path.offerLast(root.val);
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new LinkedList(path));
        }

        traverse(root.left, targetSum);
        traverse(root.right, targetSum);
        path.pollLast();
    }
}
