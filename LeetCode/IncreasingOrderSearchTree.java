package com.isoftstone.file.vacamanager.ayuan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanyaun
 * @Desc 递增顺序查找树
 * <p>
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 * @Date 2020/10/12 15:44
 */
public class IncreasingOrderSearchTree {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode ret = new TreeNode(0);
        TreeNode cur = ret;
        List<Integer> sort = new ArrayList<>();
        dfs(root, sort);
        for (int i = 0; i < sort.size(); i++) {
            cur.right = new TreeNode(sort.get(i));
            cur = cur.right;
        }
        return ret.right;
    }

    public void dfs(TreeNode root, List<Integer> sort) {
        //结束条件
        if (root == null) {
            return;
        }
        //左
        dfs(root.left, sort);
        //根
        sort.add(root.val);
        //右
        dfs(root.right, sort);
    }
}
