# [Multiples of 3 or 5](https://www.codewars.com/kata/514b92a657cdc65150000006/solutions/java/all/newest)

```java
import java.util.stream.*;

public class Solution {

  public int solution(int n) {
    return IntStream
        //范围
                .range(1, n)
        //filter() 过滤出符合要求的内容(满足条件(x % 3 == 0 || x % 5 == 0)的 x留下来，其他的过滤掉)
                .filter(x -> (x % 3 == 0 || x % 5 == 0))
                .sum();
  }
}
```

```java
public class Solution {

  public int solution(int number) {
  System.out.println(number);
    int ret = 0;
    for(int i =0;i<number;i++){
       if(i%3==0||i%5==0){
         ret+=i;
       }
    }
    return ret;  
  } 
}
```

