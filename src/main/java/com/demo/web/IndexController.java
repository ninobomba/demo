package com.demo.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController
{

	@RequestMapping("/")
	public String index(HttpServletResponse response) {
		return "index";
	}

}
