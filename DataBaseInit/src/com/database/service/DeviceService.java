package com.database.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.dao.DeviceDao;
import com.database.po.Device;
import com.database.utils.PageVo;

@Service
public class DeviceService {

@Autowired
private DeviceDao deviceDao;

	public Boolean  insertDevice(Device device){

		Boolean flag=false;
		if(deviceDao.insertDevice(device)>0){
		flag=true;
		}
		return flag;
	}

	public Boolean  updateDevice(Device device){

		Boolean flag=false;
		if(deviceDao.updateDevice(device)>0){
		flag=true;
		}
		return flag;
	}

	public PageVo  getDeviceList(Device device){

		PageVo  pageVo= new PageVo();
		List<Device> list=null;
		list=deviceDao.getDeviceList(device);
		pageVo.setRoot(list);
		pageVo.setTotal(deviceDao.getDeviceListCount(device));
		return pageVo;
	}

	public Device  getDevice(String id){

		Device obj =null;
		obj=deviceDao.getDeviceById(id);
		return obj;
	}

}