package com.huibur.ass.hwserver.ayuan;

/**
 * @date 2020/5/28 14:46
 */
public class LeetCode53 {
    /**
     * 面试题53 - II. 0～n-1 中缺失的数字
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 2)
                return nums[i] - 1;
        }
        if (nums[0] == 0) {
            return nums[nums.length - 1] + 1;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1};
        int ret = missingNumber(nums);
        System.out.println(ret);

    }
}
