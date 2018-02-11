/** 
 * <pre>项目名称:springsecuritysample 
 * 文件名称:HySecurity.java 
 * 包名:com.hyhy.security 
 * 创建日期:2018年2月8日下午2:01:22 
 * Copyright (c) 2018, lizexing@163.com All Rights Reserved.</pre> 
 */  
package com.hyhy.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.hyhy.util.RedisUtils;

import ch.qos.logback.classic.Logger;

/** 
 * <pre>项目名称：springsecuritysample    
 * 类名称：HySecurity    
 * 类描述：    
 * 创建人：廖惠仪 liaohuiyi@huiyihuiying.com    
 * 创建时间：2018年2月8日 下午2:01:22    
 * 修改人：廖惠仪 liaohuiyi@huiyihuiying.com       
 * 修改时间：2018年2月8日 下午2:01:22    
 * 修改备注：       
 * @version </pre>    
 */
@Component("HySecurity")
public class HySecurity {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(HySecurity.class);
	
	@Autowired
    private RedisUtils redisUtils;
	
	@SuppressWarnings("unchecked")
	public boolean check(Authentication authentication, HttpServletRequest request){
		Object principal = authentication.getPrincipal();
		if(principal != null && principal instanceof UserDetails){
			String username = ((UserDetails)principal).getUsername();
			logger.info("username:{} has these roles:", username);
			List<String> protectedResources = (List<String>) redisUtils.get("protectedResources");
			StringBuffer reqUrl = request.getRequestURL();
			if(((UserDetails)principal).getAuthorities().isEmpty()){
				if(protectedResources.isEmpty()){
					return true;
				}else{
					for(String resource : protectedResources){
						if(reqUrl.toString().contains(resource)){
							return false;
						}
					}
					return true;
				}
			}else{
				List<String> accessAuths = null;
				for(String resource : protectedResources){
					if(reqUrl.toString().contains(resource)){
						accessAuths = (List<String>) redisUtils.get("resource");
					}
				}
				if(accessAuths == null || accessAuths.isEmpty()){
					return true;
				}
				for(GrantedAuthority auth : ((UserDetails)principal).getAuthorities()){
					logger.info(auth.getAuthority());
					for(String accessAuth : accessAuths){
						if(auth.getAuthority().equals(accessAuth)){
							return true;
						}
					}
				}
				return false;
			}
		}
		return false;
	}
}
