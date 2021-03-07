import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class No652 {
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

    HashMap<String, Integer> sub;
    LinkedList<TreeNode> res;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        sub = new HashMap<>();
        res = new LinkedList<>();
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String rightTree = traverse(root.right);
        StringBuilder subTree = new StringBuilder(traverse(root.left));
        subTree.append(",").append(rightTree).append(",").append(root.val);

        int count = sub.getOrDefault(subTree.toString(), 0);
        if (count == 1) {
            res.add(root);
        }
        sub.put(subTree.toString(), count + 1);

        return subTree.toString();
    }
}
