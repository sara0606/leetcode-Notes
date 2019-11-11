# [Directions Reduction](https://www.codewars.com/kata/directions-reduction/train/java)

```java
import java.util.*;

public class DirReduction {

    private static String N = "NORTH", S = "SOUTH", E = "EAST", W = "WEST";
    
    public static String[] dirReduc(String[] A) {
         if(A == null || A.length == 0) return new String[0];
         
        Stack<String> stack = new Stack<>();
        
        for(String s : A){
          if(stack.isEmpty()){
             stack.push(s);
             continue;
          }
          if(!stack.isEmpty() && isOppo(stack.peek(), s))
            stack.pop();
          else
            stack.push(s);   
        }
        
        System.out.println(stack);
        
        int len = stack.size();
        String[] ret = new String[len];
        for(int i = len - 1; i >= 0; i--) ret[i] = stack.pop();
//         System.out.println(Arrays.toString(ret));
        return ret;
    }
    
    private static boolean isOppo(String a, String b){
      if(a.equals(N)) return b.equals(S);
      else if(a.equals(S)) return b.equals(N);
      else if(a.equals(W)) return b.equals(E);
      else return b.equals(W);
    }
}
```

