# [Sum of Odd Cubed Numbers](https://www.codewars.com/kata/sum-of-odd-cubed-numbers/train/java)
```java
public class FindOddCubes {
 
 public static int cubeOdd(int arr[]) {
    if(arr == null || arr.length ==0)return 0;
    int ret=0;
    
    for(int i = 0;i < arr.length; i++){    
    
       arr[i]=arr[i]*arr[i]*arr[i];
       if(arr[i]%2!=0){
           ret+=arr[i] ;  
        } 
    } 
    return ret;
  }
}
```

