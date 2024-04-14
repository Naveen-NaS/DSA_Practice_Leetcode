public class Day_73 {

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        if (root.left != null)
            sum += sumOfLeftLeaves(root.left);

        if (root.right != null)
            sum += sumOfLeftLeaves(root.right);

        return sum;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(6);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(14);
        tree.right.left = new TreeNode(12);

        System.out.println(sumOfLeftLeaves(tree));
    }
}

class TreeNode {
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