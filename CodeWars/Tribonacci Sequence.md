# [Tribonacci Sequence](https://www.codewars.com/kata/tribonacci-sequence/train/java)

```java
import java.util.*;
public class Xbonacci {

  public double[] tribonacci(double[] s, int n) {
      if(n<0) return null;
      if(n == 0) return new double[0]; //new double[](); 空数组
      
      double[] ret = new double[n];
//       if(n == 1) return new double[]{s[0]};
//       if(n == 2) return  new double[]{s[0],s[1]};
//       if(n == 3) return new double[]{s[0],s[1],s[2]};
      
      for(int i = 0;i < n;i++){
            
         if(i>=3){
            ret[i] = ret[i-3]+ret[i-2]+ret[i-1];//s[]只有3个元素，以后算ret后都要用ret的元素去做加法。
          }
          else
             ret[i]= s[i];
      }
      return ret;
        
  }
}
```

