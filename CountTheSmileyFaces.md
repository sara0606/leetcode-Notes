# [Count the smiley faces!](https://www.codewars.com/kata/583203e6eb35d7980400002a/solutions/java)

```java
1.正则表达式
import java.util.*;

public class SmileFaces {
  public static int countSmileys(List<String> arr) {
     //filter()会保留 括号中true是情况，过滤掉false情况
      //正则表达式 [:;] ---->表示: ;任选一个
      //[-~]?  ---->表示- ~ 可有可无，有的话两者选一个
    return (int)arr.stream().filter( x -> x.matches("[:;][-~]?[)D]")).count();   
  }
}
```
```java
2.我的解答
import java.util.*;

public class SmileFaces {
  public static int countSmileys(List<String> arr) {
      // Just Smile :)
      int count = 0;
      //arr.size()链表的长度
      if(arr.size()==0) return 0;
      for(String each:arr){
        if(each.charAt(0)==':'||each.charAt(0)==';'){
          //三个字符的情况
          //each.length()  数组元素的长度
            if(each.length() ==3){  
            if(each.charAt(1)=='-'||each.charAt(1)=='~'){
               if(each.charAt(2)==')'||each.charAt(2)=='D'){
                  count ++;     
               }                        
            }
           }else{
            //两个字符的情况
            if(each.charAt(1)==')'||each.charAt(1)=='D')
                  count ++;
         }
        }            
      }         
      return count;
  }
}
```
