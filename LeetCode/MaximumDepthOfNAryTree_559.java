package com.isoftstone.file.vacamanager.ayuan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yuanyaun
 * @Desc N叉树的最大深度
 * <p>
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * @Date 2020/10/12 17:52
 */
public class MaximumDepthOfNAryTree_559 {

    class Node {

        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public int maxDepth(Node root) {
        //特殊情况
        if (root == null) {
            //无根节点
            return 0;
        } else if (root.children.isEmpty()) {
            //只有根节点
            return 1;
        } else {
            //普通情况
            List<Integer> heights = new ArrayList<>();
            for (Node child : root.children) {
                //这里要去求孩子节点的最大深度
                heights.add(maxDepth(child));
            }
            return Collections.max(heights) + 1;
        }
    }
}
