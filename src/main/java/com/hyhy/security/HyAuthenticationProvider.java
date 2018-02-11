/** 
 * <pre>项目名称:springsecuritysample 
 * 文件名称:HyAuthenticationProvider.java 
 * 包名:com.hyhy.security 
 * 创建日期:2018年2月8日下午3:19:57 
 * Copyright (c) 2018, lizexing@163.com All Rights Reserved.</pre> 
 */  
package com.hyhy.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/** 
 * <pre>项目名称：springsecuritysample    
 * 类名称：HyAuthenticationProvider    
 * 类描述：    
 * 创建人：廖惠仪 liaohuiyi@huiyihuiying.com    
 * 创建时间：2018年2月8日 下午3:19:57    
 * 修改人：廖惠仪 liaohuiyi@huiyihuiying.com       
 * 修改时间：2018年2月8日 下午3:19:57    
 * 修改备注：       
 * @version </pre>    
 */
public class HyAuthenticationProvider implements AuthenticationProvider {
	
	/* (non-Javadoc)    
	 * @see org.springframework.security.authentication.AuthenticationProvider#authenticate(org.springframework.security.core.Authentication)    
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)    
	 * @see org.springframework.security.authentication.AuthenticationProvider#supports(java.lang.Class)    
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}
}
