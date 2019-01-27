# 第一次成功的ssm框架整合以及日常踩坑

## 1.Maven工程:Unable to read TLD "META-INF/c.tld" from JAR file 报错的一种解决方法

**异常信息：**

```shell
exception

org.apache.jasper.JasperException: /WEB-INF/jsp/userinfo.jsp (line: 3, column: 62) Unable to read TLD "META-INF/c.tld" from JAR file "file:/D:/DevRepository/mvn_repo/repository/javax/servlet/jsp/jstl/jstl/1.2/jstl-1.2.jar": org.apache.jasper.JasperException: Failed to load or instantiate TagLibraryValidator class: org.apache.taglibs.standard.tlv.JstlCoreTLV
	org.apache.jasper.compiler.DefaultErrorHandler.jspError(DefaultErrorHandler.java:42)
	org.apache.jasper.compiler.ErrorDispatcher.dispatch(ErrorDispatcher.java:443)
	org.apache.jasper.compiler.ErrorDispatcher.jspError(ErrorDispatcher.java:219)
	org.apache.jasper.compiler.TagLibraryInfoImpl.<init>(TagLibraryInfoImpl.java:182)
	org.apache.jasper.compiler.Parser.parseTaglibDirective(Parser.java:410)
	org.apache.jasper.compiler.Parser.parseDirective(Parser.java:475)
	org.apache.jasper.compiler.Parser.parseElements(Parser.java:1427)
	org.apache.jasper.compiler.Parser.parse(Parser.java:138)
	org.apache.jasper.compiler.ParserController.doParse(ParserController.java:242)
	org.apache.jasper.compiler.ParserController.parse(ParserController.java:102)
	org.apache.jasper.compiler.Compiler.generateJava(Compiler.java:198)
	org.apache.jasper.compiler.Compiler.compile(Compiler.java:373)
	org.apache.jasper.compiler.Compiler.compile(Compiler.java:353)
	org.apache.jasper.compiler.Compiler.compile(Compiler.java:340)

```

**解决方法：**

将pom.xml文件中jstl的依赖:

```xml
<dependency>
    <groupId>javax.servlet.jsp.jstl</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>
```

改为：

```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>
```

## 2.springmvc  context:component-scan 报错500

问题原因：

原因是我的springmvc配置版本过低或者理解为我的jdk版本过高

解决办法就是把springmvc的的jar包替换为4.0版本以上的 或者 把jdk降到1.7。

## 3.Unable to convert string "${item.createtime}" to class "java.util.Date" for attribute "value": Prope即jstl表达式异常，可能需要把web.xml更改一下

原先的是：

```xml
<!DOCTYPE web-app PUBLIC
                "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
                "http://java.sun.com/dtd/web-app_2_3.dtd" >
<web-app>
</web-app>
```

要改为：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://java.sun.com/xml/ns/javaee" xmlns:web="http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
         id="WebApp_ID" version="2.5">
</web-app>
```

## 4.idea设置tomcat虚拟路径的两种方法

### **1.使用tomcat自己的虚拟路径**

#### **1.1.在tomcat\config\server.xml中配置**

path="/upload" 虚拟路径

E:\photo\upload 图片存放的真实路径

```xml
<Context  path="/upload"  docBase="E:\photo\upload" reloadable="true"/></Host>
```

#### 1.2.将Deploy applications configured in Tomcat instance勾上

Configurations.

### 2.用idea设置虚拟路径

#### 2.1.Deploy applications configured in Tomcat instance不要勾上

![https://img-blog.csdn.net/20170416214654676?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvQ2hlbmV5NTUwOTk1MzUz/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center]()

### 

![https://img-blog.csdn.net/20170416214805755?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvQ2hlbmV5NTUwOTk1MzUz/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center]()

![https://img-blog.csdn.net/20170416215106381?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvQ2hlbmV5NTUwOTk1MzUz/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center]()

## 5.No converter found for return value of type解决方法

最近在学习SpringMVC过程中，项目在ajax与后台交互的时候，前台的ajax一直接收不到后台Controller返回来的包装类对象的json数据，spring版本为4.2.4，java对象和json对象转换一直报错：

```shell

```

错误为没有该类型值的转换器，但是@responseBody注解会自动将返回数据封装成json格式，前台接收不到json对象，应该为json包版本冲突问题。 

maven包依赖原本为：

```xml

```

更改为：

```xml
<dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-annotations</artifactId>
      <version>2.7.4</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.7.4</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.7.4</version>
    </dependency>
```

