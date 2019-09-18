# [Spacify](https://www.codewars.com/kata/spacify/train/java)
```java
public class Spacify {
    public static String spacify(String str){
       String ret="";
       if(str==null) return "";
       for(int i=0;i<str.length();i++){
          //遍历字符串，取某一个字符  str.charAt(i)
          ret= ret+str.charAt(i);
           //最后一个字符不加“ ” ，最后一个元素位置 str.length()-1  
           //注意长度方法 length() 带括号
          if(i!=str.length()-1)
            ret+=" ";          
       }
       return ret;
    }
}
```