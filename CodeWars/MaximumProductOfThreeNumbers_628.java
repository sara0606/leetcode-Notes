package CodeWars;

import java.util.Arrays;

/**
 * @author yuanyuan
 * @Desc 628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 * @Date 2020/9/9 17:58
 */
public class MaximumProductOfThreeNumbers_628 {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        //数组>0,最大值一定是排序后最后三个值乘 如果有负数，最大值第一个（最大负数）*第二个（可能为负、正）*最后一个
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
