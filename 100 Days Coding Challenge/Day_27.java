// Problem No : 513 "Find Bottom Left Tree Value"

/* Aim :- Given the root of a binary tree, return the leftmost value in the last row of the tree. */

import java.util.*;

public class Day_27 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
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
         * 1 4
         */
        TreeNode root = solution.new TreeNode(2);
        root.left = solution.new TreeNode(1);
        root.right = solution.new TreeNode(4);

        System.out.println("Leftmost value in the last row: " + solution.findBottomLeftValue(root)); // Output: 1
    }
}
