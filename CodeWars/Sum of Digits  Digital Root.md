# [Sum of Digits / Digital Root](https://www.codewars.com/kata/sum-of-digits-slash-digital-root/solutions/java/me/best_practice)

```java
1.递归
public class DRoot {
  public static int digital_root(int n) {
  //对结果进行操作
  //如果结果不是个位数字，那么就要递归的调用对他每一位求和的函数，直到剩下个位为止。
    int ret = n;
    while(ret > 9){
       ret = sumDigits(ret);
       System.out.println(ret);
    }
    return ret;   
  }
  public static  int sumDigits(int n){
    int sum = 0;
    //到0的时候不需要再处理了
    //23  low=3，sum=3，n=2    low=2,sum=3+2=5,n=0停止
    while(n>0){
       int low = n %10;
       sum+=low;
       n = n / 10;
    }
    return sum;
  }
  
}
```

```java
public class DRoot {
  public static int digital_root(int n) {
    return (n != 0 && n%9 == 0) ? 9 : n % 9;
  }
}
```