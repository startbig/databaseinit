package com.database.service;

import java.util.Map;

import com.database.utils.PageVo;
import com.database.po.Gene;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * GeneService数据库操作接口类
 * 
 **/

public interface GeneService{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Gene  selectById (  String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	PageVo  selectGeneList  ( Gene record);

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
	boolean deleteGene( Gene record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	boolean insertGene( Gene record );

	
	void insertGeneList( Map map );
	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	boolean updateGene( Gene record );
}