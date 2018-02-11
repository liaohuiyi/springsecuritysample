/** 
 * <pre>项目名称:springsecuritysample 
 * 文件名称:Role.java 
 * 包名:com.hyhy.security 
 * 创建日期:2018年2月8日下午2:42:04 
 * Copyright (c) 2018, lizexing@163.com All Rights Reserved.</pre> 
 */  
package com.hyhy.security;

import java.math.BigInteger;

/** 
 * <pre>项目名称：springsecuritysample    
 * 类名称：Role    
 * 类描述：    
 * 创建人：廖惠仪 liaohuiyi@huiyihuiying.com    
 * 创建时间：2018年2月8日 下午2:42:04    
 * 修改人：廖惠仪 liaohuiyi@huiyihuiying.com       
 * 修改时间：2018年2月8日 下午2:42:04    
 * 修改备注：       
 * @version </pre>    
 */
public class Role {
	private BigInteger id;
	
	private String roleName;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
