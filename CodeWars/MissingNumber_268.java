package CodeWars;

import java.util.Arrays;

/**
 * @author yuanyuan
 * @Desc 268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * https://leetcode-cn.com/problems/missing-number/
 * @Date 2020/9/9 15:47
 */
public class MissingNumber_268 {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        // 判断 n 是否出现在末位
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        // 判断 0 是否出现在首位
        else if (nums[0] != 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 2) {
                return nums[i] - 1;
            }
        }
        return nums[0];
    }
}
