package com.database.dao;

 import java.util.List;
import com.database.po.Roles;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * RolesDao数据库操作接口类
 * 
 **/

public interface RolesDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Roles  selectById ( @Param("id") String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	List<Roles>  selectRolesList  ( Roles record);
	/**
	 * 
	 * 查询（根据条件查询集合总数）
	 * 
	 **/
	 int  selectRolesCount  ( Roles record );

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
	int deleteRoles( Roles record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertRoles( Roles record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateRoles( Roles record );
}