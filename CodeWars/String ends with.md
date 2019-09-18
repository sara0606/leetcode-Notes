# [String ends with?](https://www.codewars.com/kata/51f2d1cafc9c0f745c00037d/solutions/java/me/best_practice)

```java
//方法一
public class Kata {
  public static boolean solution(String s, String tar) {
    if(s == null || tar == null ||tar.length() > s.length()) return false;
      //使用原字符串比较 charAt()转换成字符数组，从最后一个字符开始比较，如果不等，则false，否则循环比较到目标字符串的起始位置。
    for(int off = 0; off < tar.length(); off++){
        //注意尾元素tar.length() -1 - off 不要越界
      if(tar.charAt(tar.length() -1 - off) != s.charAt(s.length()-1 - off) )
        return false;
    }
    return true;
  }
}
```
```java
public class Kata {
  public static boolean solution(String a, String b) {
  if(a==null||b==null||a.length()<b.length()) return false;
  String tail = "";
  //会生成新的字符串 
   //str.substring(from,to) 截取字符串
  tail = a.substring(a.length()-b.length(),a.length());
  //判断字符串是否相等 .equals()  判断两个对象引用是否相等 ==，有可能两个字符串不是一个引用
  if(tail.equals(b)) return true;
    return false;
  }
}
```


