# [Vasya - Clerk](https://www.codewars.com/kata/vasya-clerk/train/java)
```java
//错误方式---没考虑币种问题
public class Line {
  public static String Tickets(int[] peo)
  {
        //Your code is here...
        if(peo[0]!=25)
           return "NO";
        else{
            int ret = peo[0];
           for(int each:peo){
              if(each-25>ret)
                 return "NO";
              else{
                 ret -= (each-25);
              }
           }           
        }
        return "YES";
  }
}
```

**考虑币种 员工收到100元，需要找给客户25*3或25+50，但是这个员工手中的100元不能找给客户**

```java
//Map<Integer, Integer> map = new HashMap<>();
import java.util.Map;
import java.util.HashMap;

public class Line {
  public static String Tickets(int[] A)
  {
     Map<Integer, Integer> map = new HashMap<>();
     
     map.put(25, 0);
     map.put(50, 0);
     map.put(100, 0);
     
     for(int x :A){
       if(x == 25) map.put(25, map.get(25) + 1);
       else if(x == 50){
         if(map.get(25) < 1) return "NO";
         map.put(25, map.get(25) - 1);
         map.put(50, map.get(50) + 1);
       }else{
         if(map.get(25) >= 1 && map.get(50) >= 1){
           map.put(25, map.get(25) - 1);
           map.put(50, map.get(50) - 1);
         }else if(map.get(25) >= 3){
           map.put(25, map.get(25) - 3);
         }else{
           return "NO";
         }
       }
     }
     return "YES";
  }
}
```
```java
//使用变量记录
public class Line {
    public static String Tickets(int[] peopleInLine){
        int bill25 = 0, bill50 = 0;
        for (int payment : peopleInLine){
            if(payment==25){
                bill25++;
            } else if(payment==50){
                bill25--;
                bill50++;
            } else if(payment==100){
                if(bill50>0){
                    bill50--;
                    bill25--;
                } else{
                    bill25-=3;
                }
            }
            if(bill25<0 || bill50 <0){
                return "NO";
            }
        }
        return "YES";
    }
}
```

