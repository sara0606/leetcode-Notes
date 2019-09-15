# [Persistent Bugger](https://www.codewars.com/kata/persistent-bugger/train/java)
```java

class Persist {
	public static int persistence(long n) {
      //位数
       long digit = 0;
         //次数
       int ret = 0;
   do{
   //乘积
       long product = 1;  
       digit =0;
       do{
          long low = 0;
          //最低位
          low = n % 10;
          product *= low;
          n= n/10;         
          digit++;         
        System.out.println(n);           
       }while(n>0);       
         n=product;
         ret ++;   
    }while(digit >1);  
        //因为多算了一个 第一次多算了  比如5,应该返回0，但是 1*5=5，ret=1
      return ret-1;  
	}
}
```

