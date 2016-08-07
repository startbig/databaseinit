package com.database.dao;

 import java.util.List;
import com.database.po.Brand;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * BrandDao数据库操作接口类
 * 
 **/

public interface BrandDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Brand  selectById ( @Param("id") String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	List<Brand>  selectBrandList  ( Brand record);
	/**
	 * 
	 * 查询（根据条件查询集合总数）
	 * 
	 **/
	 int  selectBrandCount  ( Brand record );

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
	int deleteBrand( Brand record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertBrand( Brand record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateBrand( Brand record );
}