package com.isoftstone.file.vacamanager.ayuan;

/**
 * @author yuanyaun
 * @Desc 二叉树的最大深度
 * <p>
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @Date 2020/10/12 16:51
 */
public class MaximumDepthOfBinaryTree {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * height(p)={  0   , p 是空节点
     * max(height(p.left),height(p.right))+1 ,p 是非空节点
     * }
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //特殊情况
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
