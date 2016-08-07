package com.database.dao;

 import java.util.List;
import java.util.Map;

import com.database.po.Gene;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * GeneDao数据库操作接口类
 * 
 **/

public interface GeneDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Gene  selectById ( @Param("id") String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	List<Gene>  selectGeneList  ( Gene record);
	/**
	 * 
	 * 查询（根据条件查询集合总数）
	 * 
	 **/
	 int  selectGeneCount  ( Gene record );

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
	int deleteGene( Gene record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertGene( Gene record );
	void insertGeneList(Map map);
	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateGene( Gene record );
}