# [Ones and Zeros](https://www.codewars.com/kata/ones-and-zeros/train/java)

```java
import java.util.List;

public class BinaryArrayToNumber {

  public static int ConvertBinaryArrayToInt(List<Integer> binary) {
           
            if(binary == null || binary.size() == 0) return 0;
            String a = "";
            //Integer.valueOf("0101",2).toString() 二进制转十进制
            for(int i = 0;i<binary.size();i++){
               // int转换成string : String.valueOf(12)
                a+=binary.get(i).toString();
                System.out.println(a);
            }
            
            return Integer.valueOf(a,2);       
    }
}
```
```java
key="1111";
//把2进制字符串key，转成10进制keys
keys = Integer.parseInt(key, 2);//数字2代表进制，可以是各种进制，转换成10进制
//把10进制keys转成16进制result，toUpperCase()是把小写字母转换成大写字母
result= Integer.toHexString(keys).toUpperCase();
```


