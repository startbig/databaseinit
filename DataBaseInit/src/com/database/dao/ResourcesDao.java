package com.database.dao;

 import java.util.List;
import com.database.po.Resources;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * ResourcesDao数据库操作接口类
 * 
 **/

public interface ResourcesDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Resources  selectById ( @Param("id") String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	List<Resources>  selectResourcesList  ( Resources record);
	/**
	 * 
	 * 查询（根据条件查询集合总数）
	 * 
	 **/
	 int  selectResourcesCount  ( Resources record );

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
	int deleteResources( Resources record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertResources( Resources record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateResources( Resources record );
}