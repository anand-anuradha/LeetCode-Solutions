/*
Problem: Invert Binary Tree
Link: https://leetcode.com/problems/invert-binary-tree/

Approach:
- Solved the problem iteratively using Breadth-First Search (BFS).
- Start by adding the root node to the queue.
- While the queue is not empty:
    1. Remove the front node from the queue.
    2. Swap its left and right child pointers.
    3. If the left child exists, add it to the queue.
    4. If the right child exists, add it to the queue.
- Continue until all nodes are processed.

Why this works:
- Every node is visited exactly once.
- Swapping children at each node effectively mirrors the tree.
- BFS ensures all nodes are processed without recursion.

Why this approach is useful:
- Avoids recursion and potential stack overflow for very deep trees.
- Uses an explicit queue, making space usage predictable.

Time Complexity: O(n)
- Each node in the tree is visited exactly once.

Space Complexity: O(n)
- In the worst case, the queue can hold all nodes of a level.
*/


package trees;

import java.util.LinkedList;
import java.util.Queue;

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

public class InvertBinaryTreeIteratively {
    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode u = q.poll();

            TreeNode temp = u.left;
            u.left = u.right;
            u.right = temp;

            if(u.left != null){
                q.add(u.left);
            }

            if(u.right != null){
                q.add(u.right);
            }
        }

        return root;
    }
}
