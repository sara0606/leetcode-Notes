package com.isoftstone.file.vacamanager.ayuan;

/**
 * @author yuanyaun
 * @Desc 将有序数组转换为二叉搜索树
 * <p>
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @Date 2020/10/12 16:21
 */
public class ConvertSortedArrayToBinarySearchTree {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);

    }

    /**
     * 建立平衡二叉树
     *
     * @param nums  建树数字
     * @param left  左下标
     * @param right 右下标
     * @return
     */
    public TreeNode helper(int[] nums, int left, int right) {
        //特殊情况 
        if (left > right) {
            return null;
        }
        //  总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;
        //建树
        //我们可以选择中间数字作为二叉搜索树的根节点，这样分给左右子树的数字个数相同或只相差 1，
        //可以使得树保持平衡。如果数组长度是奇数，则根节点的选择是唯一的，如果数组长度是偶数，
        //则可以选择中间位置左边的数字作为根节点或者选择中间位置右边的数字作为根节点，
        //选择不同的数字作为根节点则创建的平衡二叉搜索树也是不同的。

        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = helper(nums, left, mid - 1);
        treeNode.right = helper(nums, mid + 1, right);
        return treeNode;
    }
}
