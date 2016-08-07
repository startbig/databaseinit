package com.database.service;

import com.database.utils.PageVo;
import com.database.po.RoleMenu;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * RoleMenuService数据库操作接口类
 * 
 **/

public interface RoleMenuService{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	RoleMenu  selectById (  String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	PageVo  selectRoleMenuList  ( RoleMenu record);

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
	boolean deleteRoleMenu( RoleMenu record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	boolean insertRoleMenu( RoleMenu record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	boolean updateRoleMenu( RoleMenu record );
}