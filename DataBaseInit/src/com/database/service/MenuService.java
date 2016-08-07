package com.database.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.database.po.Menu;

/**
 * 
 * MenuService数据库操作接口类
 * 
 **/

public interface MenuService{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Menu  selectById (  String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	List<Menu>  selectMenuList  ( Menu record);
	/**
	 * 
	 * 查询（根据父亲id条件查询集合）
	 * 
	 **/
	List<Menu> selectByParentId( @Param("id") String id );

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
	boolean deleteMenu( Menu record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	boolean insertMenu( Menu record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	boolean updateMenu( Menu record );
	
	 public List<Menu>   selectRolesMenus( String id );
}