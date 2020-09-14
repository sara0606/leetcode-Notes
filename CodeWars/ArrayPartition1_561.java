package CodeWars;

import java.util.Arrays;

/**
 * @author yuanyuan
 * @Desc 561. 数组拆分 I
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
 * 使得从1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * https://leetcode-cn.com/problems/array-partition-i/
 * @Date 2020/9/9 16:58
 */
public class ArrayPartition1_561 {

    public int arrayPairSum(int[] nums) {
        //排序
        Arrays.sort(nums);
        int ret = 0;
        //总和最大 min（a，b） 排序完之后就是位置为奇数的和，注意 i+2，因为取两个数中较小者
        for (int i = 0; i < nums.length; i = i + 2) {
            ret += nums[i];
        }
        return ret;
    }
}
