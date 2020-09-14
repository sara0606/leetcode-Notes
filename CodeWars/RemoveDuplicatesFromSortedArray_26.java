package CodeWars;

/**
 * @author yuanyuan
 * @Desc 删除排序数组中的重复项（双指针）
 * <p>
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * @Date 2020/9/4 16:32
 */
public class RemoveDuplicatesFromSortedArray_26 {

    public int removeDuplicates(int[] nums) {
        //特殊情况
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            //不重复元素,nums[q]放到p+1位置上，p和q均后移一个
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                //p指针后移
                p++;
            }
            q++;
        }
        //0-p位置的元素均是不重复的元素，长度下标p+1
        return p + 1;
    }
}
