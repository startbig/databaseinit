package com.database.dao;

 import java.util.List;
import com.database.po.GeneExport;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * GeneExportDao数据库操作接口类
 * 
 **/

public interface GeneExportDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	GeneExport  selectById ( @Param("id") String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	List<GeneExport>  selectGeneExportList  ( GeneExport record);
	/**
	 * 
	 * 查询（根据条件查询集合总数）
	 * 
	 **/
	 int  selectGeneExportCount  ( GeneExport record );

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
	int deleteGeneExport( GeneExport record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertGeneExport( GeneExport record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateGeneExport( GeneExport record );
	int getUGeneExportCount( GeneExport record );
	
	List<GeneExport>  getUGeneExportList( GeneExport record );
}