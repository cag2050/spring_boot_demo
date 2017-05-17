* 开发环境：
1. IDE：Eclipse IDE for Java EE Developers
2. jdk 1.8  

* 运行Spring Boot项目的方式：  
方式1：在IDE中直接执行 main 函数(运行：src/main/java/com/cag/spring_boot_demo/Application.java)，然后访问http://localhost:8080。  
方式2：用 mvn 打包为可执行jar包，然后执行java -jar xxx.jar。  
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



参考链接：http://blog.csdn.net/isea533/article/details/50278205