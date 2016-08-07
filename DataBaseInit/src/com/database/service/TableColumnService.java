package com.database.service;

import com.database.utils.PageVo;
import com.database.po.TableColumn;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * TableColumnService数据库操作接口类
 * 
 **/

public interface TableColumnService{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	TableColumn  selectById (  String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	PageVo  selectTableColumnList  ( TableColumn record);

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
	boolean deleteTableColumn( TableColumn record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	boolean insertTableColumn( TableColumn record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	boolean updateTableColumn( TableColumn record );
}