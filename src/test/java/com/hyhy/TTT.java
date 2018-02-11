/** 
 * <pre>项目名称:springsecuritysample 
 * 文件名称:TTT.java 
 * 包名:com.hyhy 
 * 创建日期:2018年2月8日下午4:31:47 
 * Copyright (c) 2018, lizexing@163.com All Rights Reserved.</pre> 
 */  
package com.hyhy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.keygen.KeyGenerators;

/** 
 * <pre>项目名称：springsecuritysample    
 * 类名称：TTT    
 * 类描述：    
 * 创建人：廖惠仪 liaohuiyi@huiyihuiying.com    
 * 创建时间：2018年2月8日 下午4:31:47    
 * 修改人：廖惠仪 liaohuiyi@huiyihuiying.com       
 * 修改时间：2018年2月8日 下午4:31:47    
 * 修改备注：       
 * @version </pre>    
 */
public class TTT {
	/*public static void main(String[] args) {
		String pwd = "password";
		String encodedPwd = new BCryptPasswordEncoder().encode(pwd);
		System.out.println(pwd);
		System.out.println(encodedPwd);
		
		String salt = KeyGenerators.string().generateKey();
		byte[] standardPwd = Encryptors.standard("qazwsx", salt).encrypt("123".getBytes());
		System.out.println(new String(standardPwd));
		String textPwd = Encryptors.text("qazwsx", salt).encrypt("123");
		System.out.println(textPwd);
		String queryableTextPwd = Encryptors.queryableText("qazwsx", salt).encrypt("123");
		System.out.println(queryableTextPwd);
	}*/
}
