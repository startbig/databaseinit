package com.database.service;

import com.database.utils.PageVo;
import com.database.po.Brand;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * BrandService数据库操作接口类
 * 
 **/

public interface BrandService{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Brand  selectById (  String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	PageVo  selectBrandList  ( Brand record);

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
	boolean deleteBrand( Brand record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	boolean insertBrand( Brand record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	boolean updateBrand( Brand record );
}