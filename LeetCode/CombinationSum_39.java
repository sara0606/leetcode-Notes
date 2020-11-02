package com.isoftstone.file.vacamanager.ayuan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanyuan
 * @Desc 组合总和
 * <p>
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * <p>
 * candidates中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * @Date 2020/10/9 16:06
 */
public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        //结果
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        //当前已组合的列表
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ret, combine, 0);
        return ret;
    }

    /**
     * 搜索回溯
     * 深度优先搜索（Depth-First-Search，DFS）
     *
     * @param candidates 组合值来源的候选数组
     * @param target     待组合目标值
     * @param ret        结果集
     * @param combine    已经组合的列表
     * @param idx        候选数组下标
     */
    public void dfs(int[] candidates, int target, List<List<Integer>> ret, List<Integer> combine, int idx) {
        //停止条件:递归的终止条件为 target <= 0 或者 candidates数组被全部用完
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ret.add(new ArrayList<Integer>(combine));
            return;
        }

        //选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ret, combine, idx);
            combine.remove(combine.size() - 1);
        }
        //直接跳过
        dfs(candidates, target, ret, combine, idx + 1);
    }

//    /**
//     * 搜索回溯的格式
//     * @param k
//     * @return
//     */
//    int search(int k)
//    {
//        if(到达目的) 输出解;
//        else
//        {
//            for(int i=1;i<=算符种数;i++)
//            {
//                if(满足条件)
//                {
//                    保存结果;
//                    search(k+1);
//                    恢复：保存结果之前的状态{回溯一步}
//                }
//            }
//        }
//    }

}
