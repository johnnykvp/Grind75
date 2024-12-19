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
    given a binary tree root node
    determine if height-balanced
    height-balanced: height of all subtrees never differs by more than one
    */

    /* Approach
    recursively iterate dfs through left and right nodes
    global boolean variable stores balanced flag
    if statement checks root is null
        return true
    call helper method on root
    return balanced flag

    helper method returns int, takes in node
    if statement checks node is null
        return 0
    int stores left subtree height
    add 1 to left subtree height
    recursive call on left node
    int stores right subtree height
    add 1 to right subtree height
    recursive call on right node
    if statement checks unbalanced abs value of left - right > 1
        set balanced node to false
    return height max of left, right
    */
    private boolean balancedFlag = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        heightBalance(root);
        return balancedFlag;
    }

    private int heightBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = 1 + heightBalance(node.left);
        int rightHeight = 1 + heightBalance(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            balancedFlag = false;
        }
        return Math.max(leftHeight,rightHeight);
    }
    /* Test
    Input:
            3
    9               20
                15      7
    leftHeight = 1 + 9node + null = 2 >> rightHeight = 1 + 20node ... 
    + 15node + null = 3 ... + 7node + null = 3 ... max(3,3) = 3 >> abs(2 - 3) = 1 >>
    balancedFlag stays true
    Output: true

    Input:
                        1
                2           2
        3           3
    4       4
    leftHeight = 1 + 2node + 3Lnode ... + 4Lnode + null = 4 ... 
    + 4Rnode + null = 4 ... max(4,4) = 4 ... + 3Rnode = 3 ... abs(3 - 4) = 1 ...
    max(3,4) = 4 >> leftHeight = 4 >> rightHeight = 1 + 2node + null = 2 >>
    abs(4 - 2) = 2 >> 2 > 1 >> balancedFlag = false
    Output: false
    */

    /* Optimize
    O(n) runtime, recursively iterate through each node given in tree
    O(1) space, no additional data structures created
    */
}