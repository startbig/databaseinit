package com.database.service;

import java.util.List;

import com.database.utils.PageVo;
import com.database.po.Syscode;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * SyscodeService数据库操作接口类
 * 
 **/

public interface SyscodeService{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Syscode  selectById (  String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	PageVo  selectSyscodeList  ( Syscode record);

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
	boolean deleteSyscode( Syscode record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	boolean insertSyscode( Syscode record );

	/**
	 * 
	 * 批量添加 （匹配有值的字段）
	 * 
	 **/
	boolean insertSyscodeList( List<Syscode> record );
	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	boolean updateSyscode( Syscode record );
}