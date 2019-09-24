#  [Stop gninnipS My sdroW!](https://www.codewars.com/kata/stop-gninnips-my-sdrow/train/java)

```java
1.StringBulider
import java.util.*;
import java.util.stream.*;

public class SpinWords {

  public String spinWords(String s) {
    if(s == null) return "";
      //先把字符串按着空格分隔，转成流stream，调用map方法，如果流中的每一个元素的长度都小于5，不变，否则反转reverse()转成字符串，再收集一下，按空格连接起来。 
    return Arrays.stream(s.split(" "))
                  .map(e -> e.length() < 5 ? 
                       e : new StringBuilder(e).reverse().toString() )
                  .collect(Collectors.joining(" "));
  }
//Collectors    import java.util.stream.*; 
```

```java

public class SpinWords {

  public String spinWords(String s) {
    //1.边界 2.把字符串按着空格转成数组
    //3.找到长度>=5的，逆着输出这个单词，其他的正序打印
    if(s == null || s.length() == 0) return "";
   String[] arr = s.split(" ");
   String ret = "";
   for(int i =0 ;i<arr.length;i++){ 
    char ss[] = arr[i].toCharArray();
      if(ss.length>=5){
        for(int j =ss.length-1 ;j>=0;j--)
         ret+=ss[j];
      }
      else ret+=arr[i];
      if(i != arr.length-1) ret+=" ";
   }  
    return ret;
  }
}
```

