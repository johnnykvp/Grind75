/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /* Clarify
    given a binary search tree (sorted, with root node)
    given two nodes
    find the LCA of the two nodes
    LCA: lowest node in the tree that is a common ancestor between nodes
    Considers a node to be a descendant of itself
    */

    /* Approach
    recursively iterate through the subtrees
    if statement checks both p and q values < current node value
        recursive call on left subtree
    if statement checks both p and q values > current node value
        recursive call on right subtree
    otherwise, p and q values are in between the current node value
    return current node because this will be the LCA
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            // Need to return node in recursive call, otherwise it will return the original root
            return lowestCommonAncestor(root.left,p,q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
    /* Test
    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
                        6
            2                   8
        0       4           7       9
            3       5
    p 2 < root 6, q 8 > root 6
    Output: 6

    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
                        6
            2                   8
        0       4           7       9
            3       5
    p 2 < root 6 && q 4 < root 6
    p 2 = root 2
    Output: 2

    Input: root = [2,1], p = 2, q = 1
        2
    1
    p 2 = root 2
    Output: 2
    */

    /* Optimize
    O(logn) runtime, recursion continuously splits the BST subtree range that needs to be checked
    O(1) space, no additional data structures created
    */
}