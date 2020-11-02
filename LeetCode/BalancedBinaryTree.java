package com.isoftstone.file.vacamanager.ayuan;

/**
 * @author yuanyaun
 * @Desc 平衡二叉树
 * <p>
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * @Date 2020/10/12 17:13
 */
public class BalancedBinaryTree {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root) {
        //特殊情况
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }


    /**
     * 计算树的高度  根左右 先序
     *
     * @param root
     * @return
     */
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }
}
