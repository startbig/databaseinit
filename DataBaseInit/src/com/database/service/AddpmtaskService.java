package com.database.service;

import com.database.utils.PageVo;
import com.database.po.Addpmtask;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * AddpmtaskService数据库操作接口类
 * 
 **/

public interface AddpmtaskService{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Addpmtask  selectById (  String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	PageVo  selectAddpmtaskList  ( Addpmtask record);

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
	boolean deleteAddpmtask( Addpmtask record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	boolean insertAddpmtask( Addpmtask record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	boolean updateAddpmtask( Addpmtask record );
}