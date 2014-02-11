package org.lichee.simple.example.web.bootstrap;

import javax.validation.Valid;

import org.lichee.simple.example.entity.SeUser;
import org.lichee.simple.example.service.UserSev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 注册
 * 
 * @author Lynch
 */
@Controller
@RequestMapping(value = "/bootstrap/register")
public class EsRegisterCol {
	
	@Autowired
	private UserSev userSev;

	/**
	 * 注册页面 
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String registerForm() {
		
		System.out.println("进来了...");
		return "bootstrap/register/register";
	}

	/**
	 * 注册功能
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String register(@Valid SeUser user, RedirectAttributes redirectAttributes) {
		
		userSev.registerUser(user);
		redirectAttributes.addFlashAttribute("username", user.getUserName());
		return "redirect:/bootstrap/login/login";
	}

	/**
	 * Ajax请求校验userName是否唯一。
	 */
	@RequestMapping(value = "checkUserName")
	@ResponseBody
	public String checkUserName(@RequestParam("userName") String userName) {
		
		if (userSev.findUserByUserName(userName) == null) {
			return "true";
		} else {
			return "false";
		}
	}
	
}
