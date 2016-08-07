package com.database.service;

import com.database.utils.PageVo;
import com.database.po.Device;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * DeviceService数据库操作接口类
 * 
 **/

public interface DeviceService{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Device  selectById (  String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	PageVo  selectDeviceList  ( Device record);

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
	boolean deleteDevice( Device record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	boolean insertDevice( Device record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	boolean updateDevice( Device record );
}