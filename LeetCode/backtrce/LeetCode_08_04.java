package backtrce;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanyuan
 */
public class LeetCode_08_04 {

    //https://leetcode-cn.com/problems/power-set-lcci/
    //可对比 全排列-LeetCode_46
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrace(ret, nums, 0, new ArrayList<>());
        return ret;
    }

    public static void backtrace(List<List<Integer>> ret, int[] nums, int index, List<Integer> combination) {
        //结束条件：所有的走过的都是子集
        ret.add(new ArrayList<>(combination));
        for (int i = index; i < nums.length; i++) {
            combination.add(nums[i]);
            backtrace(ret, nums, i + 1, combination);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums=null;
        List<List<Integer>> subsets = subsets(nums);
    }
}
