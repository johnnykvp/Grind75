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
        /* Clarify
        Given the root of a binary tree (only 2 child nodes)
        Invert the tree (swap left & right nodes)
        Return the root
        */

        /* Example
        Input: root = [2,1,3]
            2               2
        1       3   >>  3       1
        Output: return root [2,3,1]

        Input: [4,2,7,1,3,6]
                    4                               4
            2               7               7               2
        1       3       6           >>          6       3       1
        Output: return root [4,7,2,null,6,3,1]
        */


        /* Approach
        Recursion: O(n) runtime, O(n) space
        if statement checks node = null
            return null (to exit recursive loop)
        node stores temp left copy value
        set left value = right value
        set right value = temp value
        recursive call on left node
        recursive call on right node
        return root
        */

        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;

        /* Test
        Input: root = [2,1,3]
            2
        1       3
        temp = 1 >> left = 3 >> right = 1
        left = null >> right = null
        Output: return root [2,3,1]

        Input: [4,2,7,1,3,6]
                    4
            2               7
        1       3       6
        temp = 2 >> left = 7 >> right = 2
                    4
            7               2
        6               1       3
        temp = 6 >> left = null >> right = 6
        temp = 1 >> left = 3 >> right = 1
        Output: return root [4,7,2,null,6,3,1]
        */
    }
}