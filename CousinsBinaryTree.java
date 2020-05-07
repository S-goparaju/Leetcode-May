/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
*/


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
    
    int intialdepth=-1;
    boolean isCousin = false;
    
    private boolean dfs(TreeNode node, int depth, int x, int y){
        
        if (node == null){
            return false;
        }
        // Avoiding  beyond the depth restricted by the first node found.
        if(this.intialdepth!=-1 && depth>this.intialdepth){
            return false;
        }
        
        if(node.val==x || node.val==y){
            if(this.intialdepth == -1){
                 this.intialdepth = depth;
            }
               return this.intialdepth == depth;
        }

        boolean left = dfs(node.left, depth + 1, x, y);
        boolean right = dfs(node.right, depth + 1, x, y);

        // this.recordedDepth != depth + 1 would ensure node x and y are not
        // immediate child nodes, otherwise they would become siblings.
        if (left && right && this.intialdepth != depth + 1) {
            this.isCousin = true;
        }
        return left || right;
    }
        
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        // Recurse the tree to find x and y
        dfs(root, 0, x, y);
        return this.isCousin;
        
    }
}

/* time complexity = O(n)
 Space complexity = O(n)
 */
