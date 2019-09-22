# [Maximum Product](https://www.codewars.com/kata/maximum-product/train/java)

```java
public class MaxProduct {
  public int adjacentElementsProduct(int[] arr) {
    int ret = Integer.MIN_VALUE;
    for(int i = 0;i<arr.length-1;i++){
        int sum = arr[i]*arr[i+1];        
          if(ret<=sum)
             ret = sum;
    }
   return ret;    
  }
  
}
```

