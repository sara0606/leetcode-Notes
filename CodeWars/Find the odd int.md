# [Find the odd int](https://www.codewars.com/kata/54da5a58ea159efa38000836/solutions/java)

```java
1.使用异或运算 
//静态导入
//import static java.util.Arrays.*;
//stream(a).reduce(0, (x, y) -> x ^ y);
    
//Arrays.stream(a).reduce(0,(x,y) -> x ^ y);
import static java.util.Arrays.*;
public class FindOdd {
	public static int findIt(int[] a) {
    if(a==null||a.length==0)return 0;
    //a.reduce(0,(ret,x) -> ret+x )
    // 0:是ret的初始值，x是数组a中的每个元素   返回的是ret+x，将返回的结果ret+x作为新的ret进行下一个元素的遍历
    return stream(a).reduce(0, (x, y) -> x ^ y);
  }
}
```
```java
2.Map
import java.util.*;
public class FindOdd {
  public static int findIt(int[] a) {
   if(a==null ||a.length==0) return 0;

   Map<Integer,Integer> map = new HashMap<Integer, Integer>();
   for(int i =0;i<a.length;i++){
//        map.merge(a[i], 1, (k, v) -> v + 1);
     if(map.containsKey(a[i]))
         map.put(a[i],map.get(a[i])+1);
      else
         map.put(a[i],1);       
   }
    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
      int c = entry.getValue();
      if(c % 2 != 0) return entry.getKey();
    } 
    return 0;
  }
}
```
```java
3.
//数组转换成链表
int[] a;
List list = Arrays.asList(a);
//代码
import static java.util.Arrays.*;
public class FindOdd {
	public static int findIt(int[] a) {
        List list = Arrays.asList(a);
        Collections.sort(list);
        int i = 0;
        while(i < list.size()){
            int j = i+1;
            while(j < list.size() && list.get(j) == list.get(i))
                j++;
            int c= j - i;
            // 奇数的二进制尾数是1，与1做位运算后，是1
            if((c&1 )==1) return list.get(i);
            i =j;        
        }
    }
}



    

```

* ~~a~~
* b
* c
  * c1
  * c2