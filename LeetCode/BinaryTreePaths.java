package com.isoftstone.file.vacamanager.ayuan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanyaun
 * @Desc 二叉树的所有路径
 * <p>
 * 深度优先搜索
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * @Date 2020/10/12 15:15
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode root, String path, List<String> paths) {
        //root根节点得有效
        if (root != null) {
            StringBuilder pathBuilder = new StringBuilder(path);
            //当前节点放入当前路径中
            pathBuilder.append(root.val);
            //叶子节点判断
            if (root.left == null && root.right == null) {
                //叶子节点，加入叶子路径结果集
                paths.add(pathBuilder.toString());
            } else {
                //非叶子节点
                pathBuilder.append("->");
                dfs(root.left, pathBuilder.toString(), paths);
                dfs(root.right, pathBuilder.toString(), paths);
            }
        }
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
