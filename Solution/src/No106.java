import java.util.HashMap;
import java.util.Map;

public class No106 {
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

    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i ++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
        return root;
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int index = indexMap.get(rootVal);

        int leftSize = index - inStart;
        root.left = build(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
}
