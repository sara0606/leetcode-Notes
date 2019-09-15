```java
import java.util.*;

public class SmallestIntegerFinder {
    public static int findSmallestInt(int[] args) {
        int min = Integer.MAX_VALUE;
        for( int e:args){
           min = Math.min(min,e);
        }
        return min;
    }
}
```

