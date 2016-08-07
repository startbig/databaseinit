package com.database.service;

import com.database.utils.PageVo;
import com.database.po.Resources;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * ResourcesService数据库操作接口类
 * 
 **/

public interface ResourcesService{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Resources  selectById (  String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	PageVo  selectResourcesList  ( Resources record);

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
	boolean deleteResources( Resources record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	boolean insertResources( Resources record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	boolean updateResources( Resources record );
}