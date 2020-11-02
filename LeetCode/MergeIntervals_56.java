package com.isoftstone.file.vacamanager.ayuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yuanyuan
 * @Desc 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * https://leetcode-cn.com/problems/merge-intervals/
 * @Date 2020/10/9 15:11
 */
public class MergeIntervals_56 {

    public int[][] merge(int[][] intervals) {
        //特殊情况
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //按左侧元素排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //结果存储
        List<int[]> merged = new ArrayList<>();
        //遍历数组
        for (int i = 0; i < intervals.length; i++) {
            //数组下界 [0,3]中的0
            int start = intervals[i][0];
            //数组上界 [0,3]中的3
            int end = intervals[i][1];
            //判断是否符合合并的条件
            //a[i].end >= a[j].start 才能合并
            // merged.get(merged.size() - 1)[1] 指的是最后一个加入结果集中的 end值（数组下界），
            //比如最后一个元素是【1,3】那么指的是3
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < start) {
                merged.add(new int[]{start, end});
            } else {
                //符合合并，合并 将最后一个加入结果集中的 end值和当前end比较，取大的
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], end);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
