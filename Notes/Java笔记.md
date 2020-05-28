1.自动生成数据库中mybatis相关的实体等配置

https://www.cnblogs.com/williamjie/p/11344270.html

MyBatis属于一种半自动的ORM框架，所以主要的工作就是配置Mapping映射文件，但是由于手写映射文件很容易出错，所以可利用MyBatis生成器自动生成实体类、DAO接口和Mapping映射文件。这样可以省去很多的功夫，将生成的代码copy到项目工程中即可。

生成代码需要的文件和jar并建立如下目录结构：

![img](https://files.jb51.net/file_images/article/201712/2017121410352744.png)

在generatorl.xml中配置相关的数据库连接，已经数据库表：
```java
<?xml version="1.0" encoding="UTF-8"?>  
<!DOCTYPE generatorConfiguration  
 PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"  
 "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd"> 
   
<generatorConfiguration> 
  <!-- 数据库驱动 -->
  <classPathEntry location="mysql-connector-java-5.1.34.jar" /> 
  <context id="DB2Tables" targetRuntime="MyBatis3"> 
    <commentGenerator> 
      <property name="suppressDate" value="true" /> 
      <!-- 是否去除自动生成的注释 true：是 ： false:否 -->
      <property name="suppressAllComments" value="true" /> 
    </commentGenerator> 
    <!--数据库链接URL，用户名、密码 -->
    <jdbcConnection driverClass="com.mysql.jdbc.Driver"
      connectionURL="jdbc:mysql://192.168.1.194:3306/noc" 
      userId="root" password="root"> 
    </jdbcConnection> 
    <javaTypeResolver> 
      <property name="forceBigDecimals" value="false" /> 
    </javaTypeResolver> 
    <!-- 生成模型的包名和位置 -->
    <javaModelGenerator targetPackage="com.yingjun.test.model"
      targetProject="src"> 
      <property name="enableSubPackages" value="true" /> 
      <property name="trimStrings" value="true" /> 
    </javaModelGenerator> 
    <!-- 生成映射文件的包名和位置 -->
    <sqlMapGenerator targetPackage="com.yingjun.test.mapping"
      targetProject="src"> 
      <property name="enableSubPackages" value="true" /> 
    </sqlMapGenerator> 
    <!-- 生成DAO的包名和位置 -->
    <javaClientGenerator type="XMLMAPPER" targetPackage="com.yingjun.test.dao" 
       targetProject="src"> 
       <property name="enableSubPackages" value="true" /> 
    </javaClientGenerator> 
    <!-- 要生成的表 tableName是数据库中的表名或视图名 domainObjectName是实体类名 -->
    <table tableName="other_list" domainObjectName="OtherList"
      enableCountByExample="fasle" enableUpdateByExample="false"
      enableDeleteByExample="false" enableSelectByExample="false"
      selectByExampleQueryId="false" > 
    </table> 
  </context> 
</generatorConfiguration>  
```

打开CMD窗口 进入该目录结构，输入命令行：

```
java -jar mybatis-generator-core-1.3.2.jar -configfile generator.xml -overwrite
```

运行完成后会生成相应的dao mapper 和model，是不是很爽。