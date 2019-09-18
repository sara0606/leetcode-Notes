# [Reverse words](https://www.codewars.com/kata/5259b20d6021e9e14c0010d4/solutions/java)

```java
import java.util.Arrays;
import java.util.stream.Collectors;
public class Kata{
  public static String reverseWords(final String original){
    //map(s->x)  s
    return original.trim().isEmpty()?original:Arrays.stream(original.split(" ")).map(s->new StringBuilder(s).reverse().toString()).collect(Collectors.joining(" "));
  }
}
```

```java
import java.lang.StringBuffer;
public class Kata
{
  public static String reverseWords(final String original)
  {
    //按空格分开 
    String ret= "";
     String[] str =original.split(" ");
     if(str.length == 0) return original;
     for(int i =0;i<str.length;i++){
         //new StringBuffer(s).reverse().toString();  
         //StringBuffer是对字符串拼接操作的类。append在末尾添加字符串，insert在指定位置插入字符串。String字符串的拼接符号“+”，就是使用StringBuilder实现的，支持可变长度。    
        ret+= new StringBuffer(str[i]).reverse().插入();
         if(i!=str.length-1)
            ret+=" ";         
     }
      return ret;
    }
}
```

