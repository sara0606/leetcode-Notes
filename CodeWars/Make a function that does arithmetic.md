# [Make a function that does arithmetic!](https://www.codewars.com/kata/583f158ea20cfcbeb400000a/solutions/java/me/best_practice)

```java
class ArithmeticFunction {
  public static int arithmetic(int a, int b, String operator) {
  //System.out.printf(a,b,operator);
    //a永远是第一个操作数operand，所以不用考虑a与b的大小问题
      if(operator=="add"){
       return a+b;  
    }
    if(operator=="subtract"){   
       return a-b;
    }
    if(operator=="multiply"){
        return a*b;
    }
    if(operator=="divide"){
       return a/b;         
    }
    //结构的完整性 每个分支必须要有返回值
    return 0;
  }
}
```