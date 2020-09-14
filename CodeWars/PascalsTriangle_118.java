package CodeWars;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanyuan
 * @Desc 118. 杨辉三角(动态规划)
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * https://leetcode-cn.com/problems/pascals-triangle/
 * @Date 2020/9/8 14:30
 */
public class PascalsTriangle_118 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ret = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> curRows = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    //边界元素为1
                    curRows.add(1);
                } else {
                    //前一行
                    List<Integer> preRow = ret.get(i - 1);
                    //非边界元素 前一行相邻两个元素之和
                    curRows.add(preRow.get(j - 1) + preRow.get(j));
                }
            }
            ret.add(curRows);
        }
        return ret;
    }
}
