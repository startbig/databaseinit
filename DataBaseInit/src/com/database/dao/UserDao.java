package com.database.dao;

 import java.util.List;
import com.database.po.User;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * UserDao数据库操作接口类
 * 
 **/

public interface UserDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	User  selectById ( @Param("id") String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	List<User>  selectUserList  ( User record);
	/**
	 * 
	 * 查询（根据条件查询集合总数）
	 * 
	 **/
	 int  selectUserCount  ( User record );

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	int deleteById ( @Param("id") String id );

	/**
	 * 
	 * 删除（根据对象）
	 * 
	 **/
	int deleteUser( User record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertUser( User record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateUser( User record );
	/**
	 * 
	 * 登陆验证
	 * 
	 **/
	User loginUser(User user);
	
	/**
	 * 
	 * 登陆验证
	 * 
	 **/
	int exist(User user);
	
	
}