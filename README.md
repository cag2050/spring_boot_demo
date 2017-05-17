* 运行 Application.java 方式来启动Spring Boot项目，下面3种写法中选择一种  
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