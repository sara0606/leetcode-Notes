/**
* https://leetcode-cn.com/problems/symmetric-tree/
*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode n) {
       if(n == null)return true;
       return recur(n.left,n.right);
        
    }
    public boolean recur(TreeNode a,TreeNode b) {
        if(a ==null && b == null){
            return true;
        }else if(a != null && b != null && a.val == b.val){
            return recur(a.left,b.right)&& recur(a.right,b.left);
        }else{
            return false;
        }
    }
   
}