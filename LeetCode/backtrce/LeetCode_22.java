package backtrce;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanyuan
 */
public class LeetCode_22 {

    //https://leetcode-cn.com/problems/generate-parentheses/
    public static List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        //特殊情况
        if (n == 0) return ret;
        backtrace(ret, n, 0, 0, new StringBuilder());
        return ret;
    }

    public static void backtrace(List<String> ret, int n, int left, int right, StringBuilder combination) {
        //组合长度和括号组数量是二倍关系 （）,写入条件
        if (combination.length() == n * 2) {
            ret.add(combination.toString());
        }
        //最终“（”数量=n “）”数量=n  左括号<n，可以放入（
        if (left < n) {
            combination.append("(");
            backtrace(ret, n, left + 1, right, combination);
            combination.deleteCharAt(combination.length() - 1);
        }
        //右括号<左括号，可以放入）
        if (right < left) {
            combination.append(")");
            backtrace(ret, n, left, right + 1, combination);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(2);
    }
}
