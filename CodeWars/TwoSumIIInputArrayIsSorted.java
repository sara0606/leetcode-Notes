package CodeWars;

/**
 * @author yuanyuan
 * @Desc 167. 两数之和 II - 输入有序数组(双指针)
 * <p>
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @Date 2020/9/8 16:56
 */
public class TwoSumIIInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            if (numbers[low] + numbers[high] == target) {
                return new int[]{low + 1, high + 1};
            } else if (numbers[low] + numbers[high] > target) {
                //和>目标值，髙指针左移，使得两数之和减少
                high--;
            } else if (numbers[low] + numbers[high] < target) {
                //和<目标值，低指针右移，使得两数之和增大
                low++;
            }
        }
        return new int[]{-1, -1};
    }
}
