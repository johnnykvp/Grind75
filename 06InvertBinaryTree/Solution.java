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
    /* Clarify
    given root node of binary tree
    invert the tree (swap left & right nodes)
    return the root node
    will the tree need to be sorted? (no, can be given in any order)
    */

    /* Approach
    recursively iterate through nodes
    if statement checks node is null
        return null
    store current left node (including pointers, not just value)
    set left node equal to right node
    set right node equal to stored left node
    recursive call on left node
    recursive call on right node
    return root
    uses DFS by recursively visiting all left nodes first, then right nodes
    */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    /* Test
    Input:
                4            1st pass           4
        2               7       >>      7               2
    1       3       6       9       6       9       1       3
    2nd pass
                4            3rd pass
        7               2       >> null nodes, no changes
    9       6       3       1   
    Output: ^
        
    Input: null
    if statement catches null
    Output: null
    */

    /* Optimize
    O(n) runtime, based on given tree depth
    O(n) space, created nodes based on given tree depth
    */
}