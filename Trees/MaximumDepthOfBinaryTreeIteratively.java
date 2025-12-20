/*
Problem: Maximum Depth of Binary Tree
Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/

Approach:
- Solved the problem iteratively using Breadth-First Search (BFS).
- Start by adding the root node to the queue.
- While the queue is not empty:
    1. Capture the number of nodes at the current level.
    2. Process all nodes of that level.
    3. Add their left and right children to the queue.
    4. Increment depth after completing one full level.

Why this works:
- BFS processes the tree level by level.
- Each level corresponds to one unit of depth.
- Counting levels gives the maximum depth of the tree.

Why this approach is useful:
- Avoids recursion and potential stack overflow.
- Explicitly models depth using level traversal.

Time Complexity: O(n)
- Each node is visited exactly once.

Space Complexity: O(n)
- In the worst case, the queue holds all nodes at the widest level.
*/

package trees;

import java.util.LinkedList;
import java.util.Queue;

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

public class MaximumDepthOfBinaryTreeIteratively {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            depth++; // Finished one level
        }

        return depth;
    }
}
