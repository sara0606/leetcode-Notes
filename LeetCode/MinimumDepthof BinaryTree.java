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
    public int minDepth(TreeNode n) {
        int result = 0;
        //�ȵݹ� ��ȥ�������������һ��

        if(n == null) return result; 
        int depthleft =1;
        int depthright = 1;
        depthleft+= minDepth( n.left);
        depthright +=minDepth(n.right);
       //������û�У����ұߵ����   ������û�У�����ߵ����
        if(n.left == null && n.right != null) return depthright;
        if(n.left != null && n.right == null) return depthleft;
       
        return Math.min(depthleft,depthright);
    }
 public int minDepth2(TreeNode root) {
       //һ�߷���� һ�߱���
        if(root==null)return 0;
        int depthleft = 1;
        int depthright = 1;
        int ret = 1;
        if(root.left == null && root.right != null) {
            depthright += minDepth(root.right);
            ret = depthright;
            // return depthright;
        }
         else if(root.right == null && root.left != null) {           
            depthleft += minDepth(root.left);
             ret = depthleft;
             // return depthleft;
        }else if(root.right != null && root.left != null)
         { 
              ret+= Math.min( minDepth(root.left), minDepth(root.right));
         }
        else{
             ret=ret;
        }
        System.out.printf("%d %d\n",root.val,ret);
        return ret;
    }
}