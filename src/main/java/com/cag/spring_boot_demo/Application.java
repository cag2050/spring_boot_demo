package com.cag.spring_boot_demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

// 写了 @RestController，就不用写 @Controller 和 下面每个路由的 @ResponseBody 了。 @RestController = @Controller + @ResponseBody。
//@RestController
@Controller
@EnableAutoConfiguration
public class Application {
	@Value("${userName}")
	private String userName;

	@Value("${bookTitle}")
	private String bookTitle;

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!666889998";
	}

	@RequestMapping("/now")
	@ResponseBody
	String now() {
		return "现在时间888：" + (new Date()).toLocaleString();
	}

	@RequestMapping("/statichtml")
	String staticHtml() {
		// return模板文件的名称，对应
		// src/main/resources/templates/staticHtml.html，访问：http://localhost:8080/statichtml
		return "staticHtml";
	}

	@RequestMapping("/modelmap")
	String dynamicHtml1(ModelMap map) {
		// 加入属性，用来在模板中读取
		map.addAttribute("name", userName);
		map.addAttribute("bookTitle", bookTitle);
		// return模板文件的名称，对应
		// src/main/resources/templates/modelMap.html，访问：http://localhost:8080/modelmap
		return "modelMap";
	}

	@RequestMapping("/forward")
	// ModelAndView 实现地址转发
	ModelAndView forward() {
		ModelAndView view = new ModelAndView("now");
		return view;
	}

	@RequestMapping("/redirectview")
	// 地址重定向实现方式1：RedirectView
	ModelAndView redirect1() {
		RedirectView rediView = new RedirectView("/");
		return new ModelAndView(rediView);
	}

	@RequestMapping("/redirectrouter")
	// 地址重定向实现方式2：redirect: 加上 路由，推荐使用
	String redirect2() {
		return "redirect:statichtml";
	}

	public static void main(String[] args) {
		// 运行 Application.java 来启动Spring Boot项目，下面3种写法中选择一种
		// 写法1：
		// SpringApplication.run(Application.class, args);
		// 写法2：
		SpringApplication application = new SpringApplication(Application.class);
		application.run(args);
		// 写法3：
		// new
		// SpringApplicationBuilder().showBanner(false).sources(Application.class).run(args);
	}
}