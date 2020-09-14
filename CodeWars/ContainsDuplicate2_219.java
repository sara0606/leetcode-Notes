package CodeWars;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yuanyuan
 * @Desc 219. 存在重复元素 II（滑动窗口）
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * <p>
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 * @Date 2020/9/9 15:32
 */
public class ContainsDuplicate2_219 {

    /**
     * 滑动窗口，维护k大小的滑动窗口
     * 遍历数组，对于每个元素做以下操作：
     * 在散列表中搜索当前元素，如果找到了就返回 true。
     * 在散列表中插入当前元素。
     * 如果当前散列表的大小超过了 kk， 删除散列表中最旧的元素。
     * 返回 false。
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean ret = false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                ret = true;
            } else {
                set.add(nums[i]);
            }
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return ret;
    }
}
