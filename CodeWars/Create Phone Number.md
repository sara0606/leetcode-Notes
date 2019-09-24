# [Create Phone Number](https://www.codewars.com/kata/525f50e3b73515a6db000b83/solutions/java)

```java
1.暴力解决
import java.util.*;
public class Kata {
  public static String createPhoneNumber(int[] arr) {
    if(arr == null || arr.length == 0)return "";
    String sb ="(";
    for(int i =0;i<3;i++){
       sb+=(arr[i]);
    }
    sb+=(") ");
    for(int i = 3;i<6;i++){
       sb+=(arr[i]);
    }
    sb+=("-");
        for(int i = 6;i<10;i++){
       sb+=(arr[i]);
    }
    return sb;    
  }
}
```

```java
2.Str.format()
public class Kata {
  public static String createPhoneNumber(int[] numbers) {
    return String.format("(%d%d%d) %d%d%d-%d%d%d%d",numbers[0],numbers[1],numbers[2],numbers[3],numbers[4],numbers[5],numbers[6],numbers[7],numbers[8],numbers[9]);
  }
}
```

