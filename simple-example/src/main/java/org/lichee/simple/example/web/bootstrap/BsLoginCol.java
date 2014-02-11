package org.lichee.simple.example.web.bootstrap;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.lichee.simple.example.entity.SeUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 登录
 * 
 * @author Lynch
 */
@Controller
@RequestMapping(value = "/bootstrap/login")
public class BsLoginCol {

	 /**
     * 判断用户是否登录
     * @param currUser
     * @return
     */
//    @RequestMapping(method=RequestMethod.POST)
//    public String isLogin(SeUser seUser){
//    	System.out.println("没有进来");
//        Subject user = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(seUser.getUserName(),seUser.getUserPassword());
//        token.setRememberMe(true);
//        try {
//            user.login(token);
//            return "redirect:/";
//        }catch (AuthenticationException e) {
//            token.clear();
//            return "redirect:/bootstrap/login";
//        }
//    }
	
	/**
	 * 登录页面方法(get)
	 */
    @RequestMapping(method = RequestMethod.GET)
	public String login() {
    	System.out.println("-------------页面跳转方法-------------");
		return "bootstrap/login/login";
	}

    /**
     * 登录处理方法(post) 失败后重新跳转到登录页面
     * FormAuthenticationFilter.DEFAULT_USERNAME_PARAM
     * 用户名参数：username
     * 防止重复登录的令牌机制(待查询资料)
     */
	@RequestMapping(method = RequestMethod.POST)
	public String fail(
			@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName,
			Model model) {
		System.out.println("------------失败后重新跳转到登录页面------------");
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
		return "bootstrap/login/login";
	}
}
