/** 
 * <pre>项目名称:springsecuritysample 
 * 文件名称:HyUserDetails.java 
 * 包名:com.hyhy.security 
 * 创建日期:2018年2月8日下午7:49:16 
 * Copyright (c) 2018, lizexing@163.com All Rights Reserved.</pre> 
 */  
package com.hyhy.security;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/** 
 * <pre>项目名称：springsecuritysample    
 * 类名称：HyUserDetails    
 * 类描述：    
 * 创建人：廖惠仪 liaohuiyi@huiyihuiying.com    
 * 创建时间：2018年2月8日 下午7:49:16    
 * 修改人：廖惠仪 liaohuiyi@huiyihuiying.com       
 * 修改时间：2018年2月8日 下午7:49:16    
 * 修改备注：       
 * @version </pre>    
 */
public class HyUserDetails implements UserDetails {
	
	private static final long serialVersionUID = -7173665828836032451L;

	private BigInteger id;
	
	private String username;
	
	private String password;
	
	private List<Role> roles;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	/* (non-Javadoc)    
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()    
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		List<Role> roles = this.getRoles();
		for(Role role : roles){
			auths.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
		}
		return auths;
	}
	
	/* (non-Javadoc)    
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()    
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	/* (non-Javadoc)    
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()    
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	/* (non-Javadoc)    
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()    
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	/* (non-Javadoc)    
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()    
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
}
