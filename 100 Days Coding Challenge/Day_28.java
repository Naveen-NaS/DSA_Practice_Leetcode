// Problem No : 1609 "Even Odd Tree"

/* Aim :- A binary tree is named Even-Odd if it meets the following conditions:
        The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
        For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right). 
        For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
    Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false. 
*/

import java.util.*;

public class Day_28 {

    public static class TreeNode {
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

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean evenLevel = true;

        while (!q.isEmpty()) {
            int size = q.size();
            int prev = evenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (evenLevel && (node.val % 2 == 0 || node.val <= prev)) {
                    return false;
                }
                if (!evenLevel && (node.val % 2 == 1 || node.val >= prev)) {
                    return false;
                }
                prev = node.val;

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            evenLevel = !evenLevel;
        }

        return true;
    }

    public static void main(String[] args) {
        // Create a sample binary tree for testing
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(8);

        // Create an instance of the Day_28 class
        Day_28 day28 = new Day_28();

        // Test the isEvenOddTree method
        boolean result = day28.isEvenOddTree(root);

        // Print the result
        System.out.println("Is the binary tree an even-odd tree? " + result);
    }
}
