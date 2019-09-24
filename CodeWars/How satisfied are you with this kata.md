# [How satisfied are you with this kata?](https://www.codewars.com/kata/585d7d5adb20cf33cb000235/solutions/java/me/best_practice)

```java
import java.util.*;
 public class Kata {
    public static double findUniq(double arr[]) {   
      Arrays.sort(arr);
        //打印数组的每一个元素
//       System.out.println(Arrays.toString(arr));
        //反转数组
       // Arrays.reverse(arr);
        //字符串反转  
        //new StringBuilder(s).reverse() -->返回StringBuilder。
        //new StringBuilder(s).reverse().toString();
      if(arr[0]!=arr[1]) return arr[0] ;
      else  return arr[arr.length-1];
        //1,1,2
        //2,2,2,1
    }
}
```

