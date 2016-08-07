package com.database.service.impl;
import com.database.utils.PageVo;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;
import com.database.service.DeviceService;
import com.database.dao.DeviceDao;
import com.database.po.Device;

/**
 * 
 * DeviceServiceImpl数据库操作接口类
 * 
 **/

@Service
public class DeviceServiceImpl implements DeviceService{

@Resource
private DeviceDao devicedao;

	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	 public Device  selectById (  String id ){
		Device device=devicedao.selectById (id);
		  return device;
	}

	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
		 public PageVo  selectDeviceList  ( Device record){
		PageVo  pageVo= new PageVo();
		List<Device>  list=devicedao.selectDeviceList( record);
		  pageVo.setRoot(list);
		  pageVo.setTotal(devicedao.selectDeviceCount(record));
		  return  pageVo;
	}

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	 public boolean deleteById (  String id ){
		 int flag=devicedao.deleteById ( id );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }	 }

	/**
	 * 
	 * 删除（根据对象）
	 * 
	 **/
	 public boolean deleteDevice( Device record ){
		 int flag=devicedao.deleteDevice( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	 public boolean insertDevice( Device record ){
		 int flag=devicedao.insertDevice( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	 public boolean updateDevice( Device record ){
		 int flag=devicedao.updateDevice( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }

}