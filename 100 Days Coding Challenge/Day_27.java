import java.util.LinkedList;
import java.util.Queue;

public class Day_27 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode tmp;

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {

            tmp = q.poll();

            if (tmp.right != null)
                q.add(tmp.right);
            if (tmp.left != null)
                q.add(tmp.left);
        }
        return tmp.val;
    }

    public static void main(String[] args) {
        Day_27 solution = new Day_27();

        // Example usage:
        /*
         * 2
         * / \
         * 1 3
         */
        TreeNode root = solution.new TreeNode(2);
        root.left = solution.new TreeNode(1);
        root.right = solution.new TreeNode(3);

        System.out.println("Leftmost value in the last row: " + solution.findBottomLeftValue(root)); // Output: 1
    }
}
