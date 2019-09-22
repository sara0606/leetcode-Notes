# [Maximum Multiple](https://www.codewars.com/kata/maximum-multiple/train/java)

```java
public class MaxMultiple {
  public static int maxMultiple(int divisor, int bound) {
    // Your code here
    if(divisor>bound)return 0;
    int ret;
    for(int i = bound;i>0;i--){
        //整除 取余数=0，要最大的倍数，从最大的边界开始倒叙执行
       if(i%divisor==0){
           ret = i;
           return ret;
       }      
    }
      return 0;   
  }
}
```

