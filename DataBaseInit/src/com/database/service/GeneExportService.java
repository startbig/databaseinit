package com.database.service;

import com.database.utils.PageVo;
import com.database.po.GeneExport;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * GeneExportService数据库操作接口类
 * 
 **/

public interface GeneExportService{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	GeneExport  selectById (  String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	PageVo  selectGeneExportList  ( GeneExport record);

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
	boolean deleteGeneExport( GeneExport record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	boolean insertGeneExport( GeneExport record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	boolean updateGeneExport( GeneExport record );
}