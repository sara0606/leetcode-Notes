# [Are they the "same"?](https://www.codewars.com/kata/550498447451fbbd7600041c/train/java)

```java
import java.util.*;

public class AreSame {
	
	public static boolean comp(int[] a, int[] b) {
    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(b));
    
    if(a == null || b ==null ) return false;
    Set<Integer> set = new HashSet<>();
    int[] c = new int[a.length];
     for(int i =0 ;i<a.length;i++){
        c[i] = a[i]*a[i];
     }
     for(int i =0 ;i<b.length;i++){
       boolean flag = false;
        for(int j = 0;j<c.length;j++){
           if(b[i] == c[j] && !set.contains(j)) {
             flag =true;     
             set.add(j);
             break;                
           }                  
        }
        if(!flag) return false;
    }
    
    return true;
  }
}
```

