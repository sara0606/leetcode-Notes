package backtrce;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanyuan
 */
public class LeetCode_46 {
    //https://leetcode-cn.com/problems/permutations/submissions/
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) return ret;
        int[] visited = new int[nums.length];
        backtrack(ret, nums, new ArrayList<Integer>(), visited);
        return ret;
    }

    private void backtrack(List<List<Integer>> ret, int[] nums, List<Integer> combination, int[] visited) {
        if (combination.size() == nums.length) {
            ret.add(new ArrayList<>(combination));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //已经访问过
            if (visited[i] == 1) continue;
            visited[i] = 1;
            combination.add(nums[i]);
            backtrack(ret, nums, combination, visited);
            //置为未访问
            visited[i] = 0;
            combination.remove(combination.size() - 1);
        }
    }
}
