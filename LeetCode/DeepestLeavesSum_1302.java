package com.isoftstone.file.vacamanager.ayuan;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuanyaun
 * @Desc
 * @Date 2020/10/14 17:18
 */
public class DeepestLeavesSum_1302 {

    int sum = 0;
    int deepest = 0;

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //[1,2,3,4,5,null,6,7,null,null,null,null,8]

    /**
     * 层次遍历
     * 计算当前层的和，如果有子节点，继续计算下一层，只保留最后一层（叶子节点）的和
     * <p>
     * 一层层地遍历，每次都把该层的节点和加起来。
     * 如果还有下一层，上一层的节点和清零。
     * 遍历完，最后一次和就是最后一层的节点和。
     *
     * @param root
     * @return
     */
    public static int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int deepNodeSum = 0;
        while (!queue.isEmpty()) {
            deepNodeSum = 0;    // 清零
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                deepNodeSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return deepNodeSum;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.right.right = new TreeNode(6);
        treeNode.right.right.right = new TreeNode(8);
        int sum = deepestLeavesSum(treeNode);
    }


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
