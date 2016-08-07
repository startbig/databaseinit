package com.database.service;

import com.database.utils.PageVo;
import com.database.po.GeneRecord;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * GeneRecordService数据库操作接口类
 * 
 **/

public interface GeneRecordService{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	GeneRecord  selectById (  String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	PageVo  selectGeneRecordList  ( GeneRecord record);

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
	boolean deleteGeneRecord( GeneRecord record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	boolean insertGeneRecord( GeneRecord record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	boolean updateGeneRecord( GeneRecord record );
}