package backtrce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author yuanyuan
 */
public class LeetCode_17 {

    /**
     * 回溯
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        //特殊情况
        if (digits ==null || digits.length() ==0) return ret;
        //将数字与字母的对应关系存入map中
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7', "pqrs");
        map. put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(digits,0,map,ret,new StringBuilder());
        return ret;

    }


    public static void backtrack(String digits,Integer index,Map<Character,String> map,List<String> ret,StringBuilder combination){
        //组合的长度和输入的字符串的长度是一致的
        if (index == digits.length()){
            ret.add(combination.toString());
        }else {
            //找到当前数字
            char c = digits.charAt(index);
            //获取当前数字对应的字母数组
            char[] letters = map.get(c).toCharArray();
            for (int i = 0; i < letters.length; i++) {
                //当前字母加入组合中，构建组合
                char letter = letters[i];
                combination.append(letter);
                //回溯 下标后移
                backtrack(digits,index+1,map,ret,combination);
                //删除
                combination.deleteCharAt(index);
            }
        }
    }
}
