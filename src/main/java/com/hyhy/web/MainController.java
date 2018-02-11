/** 
 * <pre>项目名称:springsecurity 
 * 文件名称:MainController.java 
 * 包名:com.hyhy.web 
 * 创建日期:2018年2月7日上午10:21:13 
 * Copyright (c) 2018, lizexing@163.com All Rights Reserved.</pre> 
 */  
package com.hyhy.web;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;

/** 
 * <pre>项目名称：springsecurity    
 * 类名称：MainController    
 * 类描述：    
 * 创建人：廖惠仪 liaohuiyi@huiyihuiying.com    
 * 创建时间：2018年2月7日 上午10:21:13    
 * 修改人：廖惠仪 liaohuiyi@huiyihuiying.com       
 * 修改时间：2018年2月7日 上午10:21:13    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
public class MainController {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/")
	public String root() {
		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/user/index")
	public String userIndex() {
		return "user/index";
	}
	
	@RequestMapping("/test/index")
	public String testIndex() {
		if(SecurityContextHolder.getContext().getAuthentication() != null){
			User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			logger.info("username:{}, password:{}", principal.getUsername(), principal.getPassword());
			List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			if(authorities != null && !authorities.isEmpty()){
				for(GrantedAuthority auth : authorities){
					logger.info("authoritie:{}", auth);
				}
			}
		}
		return "test/index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}

}
