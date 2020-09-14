package com.isoftstone.file.vacamanager.ayuan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yuanyuan
 * @Desc 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * https://leetcode-cn.com/problems/contains-duplicate/
 * @Date 2020/9/9 14:52
 */
public class ContainsDuplicate_217 {

    /**
     * 先排序，两个相同的元素排序后毕竟相邻
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        boolean ret = false;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                ret = true;
                return ret;
            }
        }
        return ret;
    }

    /**
     * 存入hashset里，如果set中有，那么证明是重复元素；
     * 没有就往set里存
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate_hash(int[] nums) {
        boolean ret = false;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num)) {
                ret = true;
            } else {
                set.add(num);
            }
        }
        return ret;
    }
}
