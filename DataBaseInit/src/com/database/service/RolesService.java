package com.database.service;

import com.database.utils.PageVo;
import com.database.po.Roles;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * RolesService数据库操作接口类
 * 
 **/

public interface RolesService{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Roles  selectById (  String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	PageVo  selectRolesList  ( Roles record);

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	boolean deleteById (  String id );

	/**
	 * 
	 * 删除（根据对象）
	 * 
	 **/
	boolean deleteRoles( Roles record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	boolean insertRoles( Roles record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	boolean updateRoles( Roles record );
}