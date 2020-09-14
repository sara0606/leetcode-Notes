package CodeWars;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanyaun
 * @Desc 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 * @Date 2020/9/8 15:08
 */
public class PascalsTriangleII_119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> preRow = new ArrayList<>();
        List<Integer> curRow = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            curRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curRow.add(1);
                } else {
                    curRow.add(preRow.get(j - 1) + preRow.get(j));
                }
            }
            preRow = curRow;
        }
        return curRow;
    }
}
