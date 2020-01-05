package com.tuniu.cls.rcl.algorithm.binary_tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * XXX
 *
 * @date 2019/12/18 13:47
 */

public class BinaryTree {

    /**
     * 二叉树数据结构
     */
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 构建二叉树
     *
     * @param inputList 输入序列
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }


    /**
     * 前序遍历
     * <p>
     * 根左右 递归
     *
     * @param node 二叉树节点
     */
    public static void preOrderTravel(TreeNode node) {
        if (node == null) return;
        System.out.println(node.data);
        preOrderTravel(node.leftChild);
        preOrderTravel(node.rightChild);
    }

    /**
     * 中序遍历
     * <p>
     * 左根右 递归
     *
     * @param node 二叉树节点
     */
    public static void inOrderTravel(TreeNode node) {
        if (node == null) return;
        preOrderTravel(node.leftChild);
        System.out.println(node.data);
        preOrderTravel(node.rightChild);
    }


    //后续 左右根 递归

    /**
     * 后序遍历
     * <p>
     * 左根右 递归
     *
     * @param node 二叉树节点
     */
    public static void postOrderTravel(TreeNode node) {
        if (node == null) return;
        preOrderTravel(node.leftChild);
        preOrderTravel(node.rightChild);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, null, 6));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历：");
        preOrderTravel(treeNode);
        System.out.println("中序遍历：");
        inOrderTravel(treeNode);
        System.out.println("后序遍历：");
        postOrderTravel(treeNode);
        System.out.println("用栈遍历二叉树，前序遍历：");
        preOrderTravelWithStack(treeNode);
    }

    /**
     * 二叉树非递归前序遍历
     * <p>
     * 利用栈
     *
     * @param root 二叉树根节点
     */
    public static void preOrderTravelWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果没有左孩子，则弹出栈顶节点，访问右孩子节点
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null){
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null){
                queue.offer(node.rightChild);
            }
        }

    }


}
