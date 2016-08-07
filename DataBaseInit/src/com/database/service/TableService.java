package com.database.service;

import com.database.utils.PageVo;
import com.database.po.Table;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * TableService数据库操作接口类
 * 
 **/

public interface TableService{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Table  selectById (  String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	PageVo  selectTableList  ( Table record);

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
	boolean deleteTable( Table record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	boolean insertTable( Table record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	boolean createTable( String  sql );
}