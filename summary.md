# 总结

**1.Typora使用总结**

```java
1.
    " ```java "    
    代码块
    " ``` "
2.
   " ` "
    小型代码块
   " ` 网址
3."# XXX" 标题
   "一个#到6个#号 ，#号越少，标题越大"
4.“ [url](www.baidu.com)”  网址链接  
5.“   **加粗**  ”
  “   *斜体*  ” 
6.更多书写规范网址： https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet

```
**2.代码总结**

```java
1.  String.format()  以及占位符 %s（字符串）%d（int）
    String tripNamePreMid = String.format("<%s%s%s>",
                    vendorNameConnect,
                    resourceTripSailingName.getData().getCruiseNameZh(),
                    StringUtils.defaultString(cityNameConnect));
2.String s；
  String[] arr = s.split(" ");
数组长度 arr.length
字符串长度 arr[i].length()
3.对象的默认的HashCode如何实现？
  JVM有6中处理方式，其中一种是null<->0,另一种是利用一种编码方式把内存地址从long型转化为int型，方便进行数学运算，另一种是线程状态
4.对象的equals()比的是什么？
判断两个对象是否相等
5.若两个对象的equals（）返回true，那么他们的HashCode的返回值是否相同？
相同
6.若两个对象的HashCode的返回值相同，那么他们的equals（）值是否相同？
不一定
不同的对象会生成相同的HashCode值，不能根据HashCode值判断两个对象是否相等。但是可以根据HashCode的值判断两个对象不等，如果两个对象的HashCode值不等，则必定是两个不同的对象。
7.HashMap （数组，每个数组元素是链表类型的）
loadfactor:负载因子 一般不能超过0.75，超过0.75就要考虑扩容。因为存的太多，每一个数组中的链表过长，影响其查找速度。
resize:扩容 扩容之后，数据要重新计算在Hashmap中的存储位置。
8.
C语言：
struct Dog{
  int age;
  String name;
}
//创建对象
struct Dog *cola = malloc(sizeof(struct Dog));
//初始化
cola -> age = 11;
cola -> name = "cola";
JAVA语言：
public Dog init(String name,int age){
  this.name = name;
  this.age = age;
}
//创建和初始化一起
Dog cola = new Dog("cola",11);
9.



```