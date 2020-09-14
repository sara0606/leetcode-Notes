package CodeWars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanyuan
 * @Desc 169. 多数元素
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * https://leetcode-cn.com/problems/majority-element/
 * @Date 2020/9/8 17:10
 */
public class MajorityElement_169 {

    /**
     * 先排序；元素出现的次数会大于n/2，第一个例子是 nn 为奇数的情况，第二个例子是 nn 为偶数的情况
     * （三种排列情况，一开始是出现最多的元素，那么超过一半，一半位置肯定是这个元素；
     * 出现在中间位置；出现在尾巴位置。）
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    /**
     * 使用hash表记录次数
     *
     * @param nums
     * @return
     */
    public int majorityElement_2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //结果存放
        Map.Entry<Integer, Integer> ret = null;
        //map遍历
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (ret == null || integerIntegerEntry.getValue() > ret.getValue()) {
                ret = integerIntegerEntry;
            }
        }
        return ret.getKey();
    }
}
