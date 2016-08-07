package com.database.dao;

 import java.util.List;

import com.database.po.Table;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * TableDao数据库操作接口类
 * 
 **/

public interface TableDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Table  selectById ( @Param("id") String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	List<Table>  selectTableList  ( Table record);
	/**
	 * 
	 * 查询（根据条件查询集合总数）
	 * 
	 **/
	 int  selectTableCount  ( Table record );

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
	int deleteTable( Table record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertTable( Table record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int createTable( @Param("sql") String sql );
}