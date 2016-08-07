package com.database.dao;

 import java.util.List;
import com.database.po.Device;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * DeviceDao数据库操作接口类
 * 
 **/

public interface DeviceDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Device  selectById ( @Param("id") String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	List<Device>  selectDeviceList  ( Device record);
	/**
	 * 
	 * 查询（根据条件查询集合总数）
	 * 
	 **/
	 int  selectDeviceCount  ( Device record );

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
	int deleteDevice( Device record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertDevice( Device record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateDevice( Device record );
}