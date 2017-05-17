* 开发环境：
1. IDE：Eclipse IDE for Java EE Developers
2. jdk 1.8  

* 运行Spring Boot项目的方式：  
方式1：在IDE中直接执行 main 函数(运行：src/main/java/com/cag/spring_boot_demo/Application.java)，然后访问http://localhost:8080。  
方式2：用 mvn 打包为可执行jar包，然后执行java -jar xxx.jar。具体步骤：在项目根目录下执行mvn package将会生成一个可执行的jar包，在命令行执行java -jar xxxx.jar即可启动项目。  
方式3：执行 mvn spring-boot:run 运行项目（直接使用tomcat（默认）启动项目）。启动具体步骤：项目右击 =》Run As => Maven build... => Main标签的Goals中填写：spring-boot:run => 点击Run按钮。 停止项目步骤：命令行运行 ps -e | grep java，找到进程id，运行 kill -9 [进程id] 来停止项目。  

* 执行 main函数 方式(运行：src/main/java/com/cag/spring_boot_demo/Application.java)来启动Spring Boot项目，下面3种写法中选择一种 
写法1，最简单的写法：  
```  
SpringApplication.run(Application.class, args);  
```  
该方法返回一个ApplicationContext对象，使用注解的时候返回的具体类型是AnnotationConfigApplicationContext或AnnotationConfigEmbeddedWebApplicationContext，当支持web的时候是第二个。  
写法2：  
```  
SpringApplication application = new SpringApplication(Application.class);  
application.run(args);  
```  
SpringApplication包含了一些其他可以配置的方法，如果你想做一些配置，可以用这种方式。  
写法3：使用SpringApplicationBuilder  
```  
new SpringApplicationBuilder()
        .showBanner(false)
        .sources(Application.class)
        .run(args);  
```  
当使用SpringMVC的时候由于需要使用子容器，就需要用到SpringApplicationBuilder，该类有一个child(xxx...)方法可以添加子容器。  


* spring-boot-maven-plugin 插件
1. 该插件支持多种功能，常用的有两种，第一种是打包项目为可执行的jar包。    
在项目根目录下执行mvn package将会生成一个可执行的jar包，jar包中包含了所有依赖的jar包，只需要这一个jar包就可以运行程序，使用起来很方便。该命令执行后还会保留一个XXX.jar.original的jar包，包含了项目中单独的部分。    
生成这个可执行的jar包后，在命令行执行java -jar xxxx.jar即可启动项目。    
2. 另外一个命令就是mvn spring-boot:run，可以直接使用tomcat（默认）启动项目。    


* Spring-Loaded项目提供了强大的热部署功能，添加/删除/修改 方法/字段/接口/枚举 等代码的时候都可以热部署，速度很快，很方便。  
想在Spring Boot中使用该功能非常简单，就是在spring-boot-maven-plugin插件下面添加依赖：  
```
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>springloaded</artifactId>
        <version>1.2.5.RELEASE</version>
    </dependency>
</dependencies>
```
添加以后，通过mvn spring-boot:run启动就支持热部署了。  
注意：使用热部署的时候，需要IDE编译类后才能生效，你可以打开自动编译功能，这样在你保存修改的时候，类就自动重新加载了。    


参考链接：http://blog.csdn.net/isea533/article/details/50278205