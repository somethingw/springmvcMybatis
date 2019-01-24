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

