# [Remove duplicate words](https://www.codewars.com/kata/remove-duplicate-words/train/java)

```java
//方法1
//把字符串按空格拆分成字符数组，遍历，再把没重复出现的元素填到链表中，最后遍历链表，把元素拼接成字符串，最后一个字符串不加空格拼接。
import java.util.*;
class Solution{
    public static String removeDuplicateWords(String s){
        if(s==null||s.length()==0) return null ;
        String[] ret = s.split(" ");   
        String ss="";
        List<String> str = new ArrayList<>();

       for(int i=0;i<ret.length;i++){     
           if (!str.contains(ret[i])) {
				    str.add(ret[i]);
			   }
       }                    
       // return str.toString() ; 是打印List,应该把List中的元素拼接后打印出来
       for(int i= 0;i<str.size();i++){
          ss+=str.get(i);
          if(i!=str.size()-1){
          ss+=" ";
           }
       }
       return ss;
    }
}
```

```java
//方法2
import java.util.*;
import java.util.stream.Collectors;
class Solution{
    public static String removeDuplicateWords(String s){
        if(s==null||s.length()==0) return null ;
//        return Arrays.asList(s.split(" "))
//                       .stream()
//                       .distinct()
//                       .collect(Collectors.joining(" "));                 
      
        //转成流，distinct()去重
        //collect
         return  Arrays.stream(s.split(" ")).distinct().collect(Collectors.joining(" "));
    }
}
```

