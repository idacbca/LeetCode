import java.util.HashMap;
import java.util.Map;

public class No105 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i ++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int index = indexMap.get(rootVal);

        int leftSize = index - inStart;
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = build(preorder, preStart +leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }
}
