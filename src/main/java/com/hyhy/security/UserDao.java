/** 
 * <pre>项目名称:springsecuritysample 
 * 文件名称:UserDao.java 
 * 包名:com.hyhy.security 
 * 创建日期:2018年2月8日下午3:39:03 
 * Copyright (c) 2018, lizexing@163.com All Rights Reserved.</pre> 
 */  
package com.hyhy.security;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/** 
 * <pre>项目名称：springsecuritysample    
 * 类名称：UserDao    
 * 类描述：    
 * 创建人：廖惠仪 liaohuiyi@huiyihuiying.com    
 * 创建时间：2018年2月8日 下午3:39:03    
 * 修改人：廖惠仪 liaohuiyi@huiyihuiying.com       
 * 修改时间：2018年2月8日 下午3:39:03    
 * 修改备注：       
 * @version </pre>    
 */
@Mapper
public interface UserDao {
	
	@Select("<script>SELECT U.id, U.username, U.password "
			+ " FROM TEST_USER U"
			+ " WHERE 1 = 1 "
			+ " AND U.username = #{username} </script>")
	HyUserDetails getUserByUsername(@Param("username")String username);
	
	@Select("<script>SELECT U.id, U.username, U.password "
			+ " FROM TEST_USER U"
			+ " WHERE 1 = 1 "
			+ " AND U.username = #{username} " 
			+ " AND U.password = #{password} </script>")
	HyUserDetails getUserByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
	
	@Select("<script>SELECT R.id, R.role_name roleName "
			+ " FROM TEST_USER_ROLE UR "
			+ " LEFT JOIN TEST_ROLE R "
			+ " ON UR.role_id = R.id "
			+ " WHERE 1 = 1 "
			+ " AND UR.user_id = #{userId} </script>")
	List<Role> getUserRoles(@Param("userId")BigInteger userId);
	
}
