# [Dubstep](https://www.codewars.com/kata/551dc350bf4e526099000ae5/solutions/java)

```java
import java.util.*;
public class Dubstep {
  public static String SongDecoder (String s)
  {
     if(s == null || s.length() == 0) return "";
     String[] arr = s.split("WUB");
     System.out.println(Arrays.toString(arr));//数组遍历打印
     StringBuilder sb = new StringBuilder();
     for(int i = 0;i < arr.length;i++){
//        System.out.print(arr[i]);
//         if(arr[i].equals("")) continue;
           if(arr[i].isEmpty()) continue;
        if(i==arr.length-1) {
             sb.append(arr[i]);
        }else{    
           sb.append(arr[i]);
//            System.out.print(sb);
           sb.append(" ");   
//            System.out.print("2"+sb);
        }
     }
     return sb.toString();
     
   }
}
```

```java
//正则表达式
public class Dubstep {
  public static String SongDecoder (String song)
  {
     return song.replaceAll("(WUB)+", " ").trim();
  }
}
```

```java
//集合和数组适用
import java.util.Arrays;
import java.util.stream.Collectors;

public class Dubstep {
  public static String SongDecoder (String song)
  {
      return Arrays.stream(song.split("WUB"))
                   .filter(i -> !"".equals(i))
                   .collect(Collectors.joining(" "));
   }
}
```



