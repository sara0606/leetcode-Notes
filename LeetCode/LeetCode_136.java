import java.util.HashMap;
import java.util.Map;

public class LeetCode_136 {
    public int singleNumber(int[] nums) {

        if (nums == null || nums.length == 0) return -1;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 任何数和 0 做异或运算，结果仍然是原来的数，即 a ⊕ 0=a
     * 任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
     * 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int ret= 0;
        for (int num : nums) {
            ret ^=num;
        }
        return ret;
    }

}
