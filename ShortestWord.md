# [Shortest Word](https://www.codewars.com/kata/shortest-word/train/java)

`1 << 5`

```java
import java.util.Arrays;

public class Kata {
    public static int findShort(String s) {
        String[] arr =s.split(" ");
        int min=arr[0].length();
        for(int i =1;i<arr.length;i++){
           if(min >= arr[i].length())
              min = arr[i].length();
         
        }
        return min;
    }
}
```

```java
 java.lang.Integer
/**
     * A constant holding the minimum value an {@code int} can
     * have, -2<sup>31</sup>.
     */
    @Native public static final int   MIN_VALUE = 0x80000000;

    /**
     * A constant holding the maximum value an {@code int} can
     * have, 2<sup>31</sup>-1.
     */
    @Native public static final int   MAX_VALUE = 0x7fffffff;
```
```java
//重构1
//把最小长度min设置为最大的值，可以从头开始循环，保证第一个字符串的长度能赋给min，不用单独赋值。
import java.util.Arrays;

public class Kata {
    public static int findShort(String s) {
        String[] arr =s.split(" ");
        int min=Integer.MAX_VALUE;
        for(int i =0;i<arr.length;i++){
           if(min >= arr[i].length())
              min = arr[i].length();
         
        }
        return min;
    }
}
```
```java
//重构2
import java.util.Arrays;

public class Kata {
    public static int findShort(String s) {
        String[] arr =s.split(" ");
        int min=Integer.MAX_VALUE;
        //for-each  前边是元素类型 后边是集合或数组对象
        for(String each: arr){
           if(min >= each.length())
              min = each.length();
         
        }
        return min;
    }
}
```
```java
//重构3
import java.util.Arrays;

public class Kata {
    public static int findShort(String s) {
        String[] arr =s.split(" ");
        int min=Integer.MAX_VALUE;
        for(String each: arr)
            //使用类库 Math.min()  Math.max()
           min = Math.min(min, each.length()); 
        return min;
    }
}
```
```java
import java.util.Arrays;

public class Kata {
    public static int findShort(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(String::length).min().getAsInt();
    }
}
```

