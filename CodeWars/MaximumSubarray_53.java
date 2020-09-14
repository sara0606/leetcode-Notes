package CodeWars;

/**
 * @author yuanyuan
 * @Desc 53. 最大子序和(动态规划)
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @Date 2020/9/7 16:48
 */
public class MaximumSubarray_53 {

    /**
     * 这道题用动态规划的思路并不难解决，比较难的是后文提出的用分治法求解，但由于其不是最优解法，所以先不列出来
     * 动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ret
     * 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
     * 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
     * 每次比较 sum 和 ret的大小，将最大值置为ret，遍历结束返回结果
     * 时间复杂度：O(n)O(n)
     * <p>
     * 链接：https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int ret = nums[0];
        int sum = 0;
        for (int num : nums) {
            //sum>0,sum+=num；否则的话sum<=0对增加子序列的长度没有帮助甚至会降低和的值，让sum=num以num为开始再计算长度
            //找到sum的最大值
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            //求最大sum并记录为ret
            ret = Math.max(sum, ret);
        }
        return ret;
    }
}
