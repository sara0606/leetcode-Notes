import java.util.Stack;

public class LeetCode_20 {

    //url: https://leetcode-cn.com/problems/valid-parentheses/

    public boolean isValid(String s) {
        //特殊情况
        if (s == null || s.length() == 0) return true;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char aChar : chars) {
            if (aChar == '(') {
                stack.push(')');
            } else if (aChar == '{') {
                stack.push('}');
            } else if (aChar == '[') {
                stack.push(']');
            } else if (stack.empty() || aChar != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }
}
