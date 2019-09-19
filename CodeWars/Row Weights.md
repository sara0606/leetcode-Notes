# [Row Weights](https://www.codewars.com/kata/row-weights/train/java)

```java
public class Solution
{
    public static int[] rowWeights (final int[] w)
    {
       if(w == null ||w.length==0) return null;
       int even  = 0;
       int odd = 0;
       for(int i =0;i<w.length;i++){
          if(i%2 == 0)
             even+=w[i];
          else
            odd += w[i];
       }
        return new int[]{even, odd}; // Do your magic!
    }
}
```

