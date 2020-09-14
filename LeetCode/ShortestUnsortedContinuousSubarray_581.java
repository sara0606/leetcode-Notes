package com.isoftstone.file.vacamanager.ayuan;

import java.util.Arrays;

/**
 * @author yuanyuan
 * @Desc 581. 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 * <p>
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * @Date 2020/9/9 17:20
 */
public class ShortestUnsortedContinuousSubarray_581 {

    /**
     * 我们将数组 numsnums 进行排序，记为 sortednums_sorted 。
     * 然后我们比较 numsnums 和 sortednums_sorted 的元素来决定最左边和最右边不匹配的元素。
     * 它们之间的子数组就是要求的最短无序子数组。
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        int start = nums.length;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sortedNums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start) > 0 ? end - start + 1 : 0;
    }
}
