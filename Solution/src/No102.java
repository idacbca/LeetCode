import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No102 {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.offer(root);
        while (!nodeQ.isEmpty()) {
            int length = nodeQ.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < length; i ++) {
                TreeNode node = nodeQ.poll();
                level.add(node.val);
                if (node.left != null) {
                    nodeQ.offer(node.left);
                }
                if (node.right != null) {
                    nodeQ.offer(node.right);
                }
            }
            res.add(level);
        }

        return res;
    }
}
