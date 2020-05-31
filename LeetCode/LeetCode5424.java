package com.huibur.ass.biz.ayuan;

import java.util.Arrays;

/**
 * @date 2020/5/31 11:31
 */
public class LeetCode5424 {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length -1]-1)*(nums[nums.length-2]-1);
    }
}
