package org.lichee.simple.example.web.easyui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * easyui风格的主题框架页面
 * 
 * @author Lynch
 */
@Controller
@RequestMapping(value = "/easyui")
public class HomeCol {

	@RequestMapping(value = "/main")
	public String main() {

		return "easyui/home/main";
	}

}
