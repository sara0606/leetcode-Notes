# [Exes and Ohs](https://www.codewars.com/kata/55908aad6620c066bc00002a/solutions/java/all/newest)
```java
public class XO {
  //字符串转化成字符数组  拿到每个字符元素 String.toCharArray
  public static boolean getXO (String str) {
    
    int oo =0;
    int xx =0;
    if(str == null ||str.length()==0) return false;
    for(char each:str.toCharArray()){
       if(each =='o'||each =='O'){
          oo++;
       }
       if(each =='x'||each == 'X'){
          xx++;
        } 
    }
     // if(oo==xx){
      //   return true;
    //  }
   //  else 
     //   return false;
     //改进的地方
     return xx == oo;
  }

}
```

