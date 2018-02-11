/** 
 * <pre>项目名称:springsecuritysample 
 * 文件名称:HyUserDetailsService.java 
 * 包名:com.hyhy.security 
 * 创建日期:2018年2月8日下午1:28:17 
 * Copyright (c) 2018, lizexing@163.com All Rights Reserved.</pre> 
 */  
package com.hyhy.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

/** 
 * <pre>项目名称：springsecuritysample    
 * 类名称：HyUserDetailsService    
 * 类描述：    
 * 创建人：廖惠仪 liaohuiyi@huiyihuiying.com    
 * 创建时间：2018年2月8日 下午1:28:17    
 * 修改人：廖惠仪 liaohuiyi@huiyihuiying.com       
 * 修改时间：2018年2月8日 下午1:28:17    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class HyUserDetailsService implements UserDetailsService {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(HyUserDetailsService.class);
	
	@Autowired
	private UserDao userDao;
	
	/* (non-Javadoc)    
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)    
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			logger.info("log in username:{}.......", username);
			HyUserDetails hyUser = userDao.getUserByUsername(username);
			if(hyUser != null){
				logger.info("id:{}, username:{}, password:{}", hyUser.getId(), hyUser.getUsername(), hyUser.getPassword());
				List<Role> roles = userDao.getUserRoles(hyUser.getId());
				hyUser.setRoles(roles);
				for(Role role : roles){
					logger.info("roleId:{}, roleName:{}", role.getId(), role.getRoleName());
				}
			}else{
				throw new UsernameNotFoundException("username:" + username +" not found...");
			}
			User user = new User(hyUser.getUsername(), hyUser.getPassword(), hyUser.getAuthorities());
			/*List<SimpleGrantedAuthority> auths = new ArrayList<SimpleGrantedAuthority>();
			auths.add(new SimpleGrantedAuthority("ROLE_USER"));
			User user = new User("user", "password", auths);*/
			return user;
		} catch (Exception e) {
			logger.info("UserDetailsService exception...");
			throw e;
		}
	}
}
