# [Find the missing letter](https://www.codewars.com/kata/find-the-missing-letter/train/java)

```java
public class Kata
{
  public static char findMissingLetter(char[] A)
  {
      //char类型的 可以做数学运算 比如a+1-->b
    for(int i = 0; i < A.length - 1; i++){
      char cur = A[i], nxt = A[i + 1];
      if(cur + 1 < nxt) return (char)(cur + 1);
    }
    return ' ';
  }
}
```

