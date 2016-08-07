package com.database.service;

import com.database.utils.PageVo;
import com.database.po.Task;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * TaskService数据库操作接口类
 * 
 **/

public interface TaskService{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Task  selectById (  String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	PageVo  selectTaskList  ( Task record);

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
	boolean deleteTask( Task record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	boolean insertTask( Task record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	boolean updateTask( Task record );
}