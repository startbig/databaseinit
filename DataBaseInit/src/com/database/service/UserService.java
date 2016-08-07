package com.database.service;

import com.database.po.User;
import com.database.utils.PageVo;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * UserService数据库操作接口类
 * 
 **/

public interface UserService {

	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	User selectById(String id);

	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	PageVo selectUserList(User record);

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	boolean deleteById(String id);

	/**
	 * 
	 * 删除（根据对象）
	 * 
	 **/
	boolean deleteUser(User record);

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	boolean insertUser(User record);

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	boolean updateUser(User record);

	/**
	 * 
	 * 登陆验证
	 * 
	 **/
	User loginUser(User user);

	/**
	 * 
	 * 查询（根据条件查询集合总数）
	 * 
	 **/
	int selectUserCount(User record);

	/**
	 * 
	 * 登陆验证
	 * 
	 **/
	int exist(User user);

}