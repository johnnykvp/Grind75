/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        /* Questions
        Given 1 parameter? (Yes, root node)
        Binary tree? (Yes, max 2 children)
        Invert meaning? (Becomes right values to left, root stays same)
        */
        
        /* Approach
        recursively iterate through root nodes
        base case checks root is null
        node temp stores left node
        set left node to right node
        set right node to temp node
        recursive call left node
        recursive call right node
        */
        
        if (root == null) {
            return root;
        }
        // Swap the whole node, not the values
        // Swapping the values will not swap the whole level, only pairs in the level 
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
        
        /* Tests
        root = [2,1,3]
        root depth0 >> temp = 1 >> left = 3, right = 1
        left depth1 >> temp = null >> left = null, right = null
        left depth2 >> root = null >> return null
        right depth2 >> root = null >> return null
        >> return [3]
        right depth1 >> temp = null >> left = null, right = null
        left depth2 >> root = null >> return null
        right depth2 >> root = null >> return null
        >> return [1]
        >> return [2,3,1]
        
        root = [4,2,7,1,3,6,9]
        root depth0 >> temp = 2 >> left = 7, right = 2
        left depth1 >> temp = 1 >> left = 3, right = 1
        left depth2 >> temp = null >> left = null, right = null
        left depth3 >> root = null >> return null
        right depth3 >> root = null >> return null
        >> return [3]
        right depth2 >> temp = null, left = null, right = null
        left depth3 >> root = null >> return null
        right depth3 >> root = null >> return null
        >> return [1]
        >> return [2,3,1]
        right depth1 >> temp = 6 >> left = 9, right = 6
        left depth2 >> temp = null >> left = null, right = null
        left depth3 >> root = null >> return null
        right depth3 >> root = null >> return null
        >> return [9]
        right depth2 >> temp = null >> left = null, right = null
        left depth3 >> temp = null >> left = null, right = null
        right depth3 >> temp = null >> left = null, right = null
        >> return [6]
        >> return [7,9,6]
        >> return [4,7,2,9,6,3,1]
        */
        
        /* Optimize
        O(n) runtime, iterates through single level recursion
        O(n) space, created additional tree node
        */
    }
}