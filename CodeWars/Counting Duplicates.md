
# [Counting Duplicates](https://www.codewars.com/kata/counting-duplicates/solutions/java/following/best_practice)
```java
import java.util.stream.Collectors;

public class CountingDuplicates {
  public static int duplicateCount(String text) {
    return (int)text.toLowerCase().chars().boxed()
        .collect(Collectors.groupingBy(k>k,Collectors.counting())).
        values().stream().filter(e->e>1).count();
  }
}
```
```java
import java.util.*;

public class CountingDuplicates {
  public static int duplicateCount(String s) {
    if(s == null || s.isEmpty()) return 0;
    s = s.toLowerCase();
    char[] A = s.toCharArray();
    
    Arrays.sort(A);
    
    int ret = 0, i = 0;
    while(i < A.length){
      int j = i + 1;
      while(j < A.length && A[i] == A[j]) j++;
      if(j > i + 1) ret++;
      i = j;
    }
    return ret;
  }
}
```
```java
import java.util.*;
public class CountingDuplicates {
  public static int duplicateCount(String s) {
    if(s == null || s.length() == 0) return 0;
    s=s.toLowerCase();
    Map<Character,Integer> map = new HashMap<>();
    char [] arr = s.toCharArray();
    for(int i = 0 ; i< arr.length; i++){
        if(map.containsKey(arr[i]))
            map.put(arr[i],map.get(arr[i])+1);
        else
           map.put(arr[i],1);
    }
//     int ret=0;
//     for(Integer each:map.values()){
//       if(each >1) ret++;
//     }
//     return ret;    
      return (int)map.values().stream()
                .filter(e -> e > 1)
                .count();
  }
}
```

