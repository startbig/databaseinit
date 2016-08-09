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


	public int  insertDevice(Device device);

	public int  updateDevice(Device device);

	public List<Device>  getDeviceList(Device device);

	public int  getDeviceListCount(Device device);

	public Device  getDeviceById(String id);
}