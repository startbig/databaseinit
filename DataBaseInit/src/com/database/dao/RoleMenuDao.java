package com.database.dao;

 import java.util.List;
import com.database.po.RoleMenu;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * RoleMenuDao数据库操作接口类
 * 
 **/

public interface RoleMenuDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	RoleMenu  selectById ( @Param("id") String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	List<RoleMenu>  selectRoleMenuList  ( RoleMenu record);
	/**
	 * 
	 * 查询（根据条件查询集合总数）
	 * 
	 **/
	 int  selectRoleMenuCount  ( RoleMenu record );

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
	int deleteRoleMenu( RoleMenu record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertRoleMenu( RoleMenu record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateRoleMenu( RoleMenu record );
}