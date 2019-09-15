```java
public class SquareDigit {
  public int squareDigits(int n) {
    String con="";
   //int[] ret ;
    int ret = 1;
    if(n==0)return 0;
    else{  
      do{     
         int low =0;
         low = n % 10;
          //string拼接的时候 x+y  ---YX（从后到前）
         con = String.format("%d%s", low* low,con);
         n = n/10;    
       }while(n>0);     
    }
    return Integer.parseInt(con);
  }
}
```

