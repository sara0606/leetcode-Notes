package CodeWars;

import java.util.Arrays;

/**
 * @author yuanyuan
 * @Desc 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * @Date 2020/9/7 17:51
 */
public class MergeSortedArray_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
