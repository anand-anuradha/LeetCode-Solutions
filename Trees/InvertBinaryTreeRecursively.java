/*
Problem: Invert Binary Tree
Link: https://leetcode.com/problems/invert-binary-tree/

Approach:
- Solved the problem using recursion.
- For each node:
    1. Recursively invert the right subtree.
    2. Recursively invert the left subtree.
    3. Swap the left and right child pointers.
- The recursion continues until a null node is reached, which acts as the base case.

Why this works:
- A binary tree is defined recursively, so recursion naturally fits the problem.
- By inverting the left and right subtrees first and then swapping them, the entire tree is mirrored from bottom to top.

Why this approach is preferred:
- Very clean and intuitive solution.
- Matches the natural recursive structure of trees.

Time Complexity: O(n)
- Each node is visited exactly once.

Space Complexity: O(h) where h represents the height of the binary tree
- Space used by the recursion stack.
*/

package trees;

class TreeNode {
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

public class InvertBinaryTreeRecursively {
        public TreeNode invertTree(TreeNode root) {

            if (root == null){
                return null;
            }

            TreeNode right = invertTree(root.right);
            TreeNode left = invertTree(root.left);

            root.left = right;
            root.right = left;
            return root;

        }
}
