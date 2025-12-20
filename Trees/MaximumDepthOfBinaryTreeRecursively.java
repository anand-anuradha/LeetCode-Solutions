/*
Problem: Maximum Depth of Binary Tree
Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/

Approach:
- Solved the problem using recursion (Depth-First Search).
- If the current node is null, return 0 as the depth.
- Recursively calculate:
    - the maximum depth of the left subtree
    - the maximum depth of the right subtree
- The depth of the current node is: max(leftDepth, rightDepth) + 1

Why this works:
- A binary tree is defined recursively.
- The depth of a tree depends on the maximum depth of its subtrees.
- Recursion naturally breaks the problem into smaller subproblems.

Time Complexity: O(n)
- Each node is visited exactly once.

Space Complexity: O(h) where h represents the height of the binary tree
- Space used by the recursion stack.
*/

package trees;

public class TreeNode {
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

public class MaximumDepthOfBinaryTreeRecursively {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
