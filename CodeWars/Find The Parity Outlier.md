# [Find The Parity Outlier](https://www.codewars.com/kata/5526fc09a1bbd946250002dc/solutions/java/me/best_practice)

```java
import java.util.*;
public class FindOutlier{
  static int find(int[] arr){
  if(arr == null || arr.length == 0) return 0;
  List<Integer> odd = new LinkedList<>();
  List<Integer> even = new LinkedList<>();
  for(int i =0 ;i<arr.length;i++){
     if(arr[i] % 2 == 0) even.add(arr[i]);
     else odd.add(arr[i]);
    
  }
      //奇数的长度>1，说明奇数不只有一个，返回偶数的元素。  否则说明奇数只有一个，返回这个奇数。
 if(odd.size()>1 ) return even.get(0);
 else return odd.get(0);
}
}
```

