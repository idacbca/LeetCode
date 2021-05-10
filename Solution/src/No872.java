import java.util.Deque;
import java.util.LinkedList;

public class No872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Deque<Integer> seq1 = new LinkedList<>();
        Deque<Integer> seq2 = new LinkedList<>();
        traverse(root1, seq1);
        traverse(root2, seq2);
        return seq1.equals(seq2);
    }

    private void traverse(TreeNode root, Deque<Integer> seq) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            seq.push(root.val);
            return;
        }
        traverse(root.left, seq);
        traverse(root.right, seq);
    }
}
