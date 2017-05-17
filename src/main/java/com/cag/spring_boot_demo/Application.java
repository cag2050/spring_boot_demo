package com.cag.spring_boot_demo;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Application {

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	@RequestMapping("/now")
	String hehe() {
		return "现在时间：" + (new Date()).toLocaleString();
	}

	public static void main(String[] args) {
		// 运行 Application.java 来启动Spring Boot项目，下面3种写法中选择一种
		// 写法1：
//		SpringApplication.run(Application.class, args);
		// 写法2：
		SpringApplication application = new SpringApplication(Application.class);
		application.run(args);
		// 写法3：
//		new SpringApplicationBuilder().showBanner(false).sources(Application.class).run(args);
	}
}