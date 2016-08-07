package com.database.dao;

 import java.util.List;
import com.database.po.GeneRecord;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * GeneRecordDao数据库操作接口类
 * 
 **/

public interface GeneRecordDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	GeneRecord  selectById ( @Param("id") String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	List<GeneRecord>  selectGeneRecordList  ( GeneRecord record);
	/**
	 * 
	 * 查询（根据条件查询集合总数）
	 * 
	 **/
	 int  selectGeneRecordCount  ( GeneRecord record );

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
	int deleteGeneRecord( GeneRecord record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertGeneRecord( GeneRecord record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateGeneRecord( GeneRecord record );
}