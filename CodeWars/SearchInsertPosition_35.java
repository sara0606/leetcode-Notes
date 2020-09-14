package CodeWars;

/**
 * @author yuanyuan
 * @Desc 搜索插入位置(二分查找)
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * <p>
 * https://leetcode-cn.com/problems/search-insert-position/
 * @Date 2020/9/4 17:09
 */
public class SearchInsertPosition_35 {

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                //中间值<目标值，left左移;为了使中间值变大
                left = mid + 1;
            } else {
                //中间值>目标值，right左移；为了使中间值变小
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 二分查找法模板
     *
     * @param nums   待分割的数组
     * @param target 目标值
     * @return 位置
     */
    public int BinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // 注意
        while (left <= right) { // 注意
            int mid = (left + right) / 2; // 注意
            if (nums[mid] == target) { // 注意
                // 相关逻辑
            } else if (nums[mid] < target) {
                //中间值<目标值，left左移;为了使中间值变大
                left = mid + 1; // 注意
            } else {
                //中间值>目标值，right左移；为了使中间值变小
                right = mid - 1; // 注意
            }
        }
        // 相关返回值
        return 0;
    }
}

