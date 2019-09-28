# [Convert string to camel case](https://www.codewars.com/kata/convert-string-to-camel-case/train/java)
```java
import java.lang.StringBuilder;
class Solution{

 static String toCamelCase(String s){
            if(s == null || s.length() == 0) return "";
            StringBuilder sb =new StringBuilder();
            for(int i = 0;i < s.length(); i++){
                if(s.charAt(i) != '_'&& s.charAt(i) != '-' ){
                    sb.append(s.charAt(i));
                }
                else{
                if(i+1<s.length()){
                    char c = Character.toUpperCase(s.charAt(i+1));
                    sb.append(c);
                    //i++;直接到_ 或-的字符的下一个字符的下一个，不然会重复打印_ 或-的字符的下一个字符
                    i++;
                    }
                }
            }
            System.out.println(sb);
            return sb.toString();
        }
}
```


1.String是不可变长度的，变长度的是StringBuilder

2. char类型的不能复制成空字符，String类型的可以复制成空字符串。
3. 字符串转成字符，获取某一个  str.charAt（i）
4. StringBuileder.append()返回的StringBuilder对象,转换成字符串，需要调用toString（）
5. 字符转成大写字母。char c ='a',c=Character.toUpperCase(c)
  字符串转成大写字母 str.toUpperCase()  小写str.toLowerCase()
6. 字符  isUpperCase 判断是不是大写，返回true或false
7. setCharAt（int index, char ch）
  给字符的某个位置上设定固定值

