package com.database.dao;

 import java.util.List;

import com.database.po.Menu;
import com.database.po.UserMenus;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * MenuDao数据库操作接口类
 * 
 **/

public interface MenuDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Menu  selectById ( @Param("id") String id );
	
	/**
	 * 
	 * 查询（根据父亲id条件查询集合）
	 * 
	 **/
	List<Menu> selectByParentId( @Param("id") String id );
	
	List<Menu> selectRolesMenus( @Param("id") String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	List<Menu>  selectMenuList  ( Menu record);
	/**
	 * 
	 * 查询（根据条件查询集合总数）
	 * 
	 **/
	 int  selectMenuCount  ( Menu record );

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
	int deleteMenu( Menu record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertMenu( Menu record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateMenu( Menu record );
	
	public int insertUserMenu(List<UserMenus> list);
	
	int deleteByUserId ( @Param("id") String id );
}