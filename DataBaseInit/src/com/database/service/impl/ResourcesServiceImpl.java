package com.database.service.impl;
import com.database.utils.PageVo;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;
import com.database.service.ResourcesService;
import com.database.dao.ResourcesDao;
import com.database.po.Resources;

/**
 * 
 * ResourcesServiceImpl数据库操作接口类
 * 
 **/

@Service
public class ResourcesServiceImpl implements ResourcesService{

@Resource
private ResourcesDao resourcesdao;

	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	 public Resources  selectById (  String id ){
		Resources resources=resourcesdao.selectById (id);
		  return resources;
	}

	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
		 public PageVo  selectResourcesList  ( Resources record){
		PageVo  pageVo= new PageVo();
		List<Resources>  list=resourcesdao.selectResourcesList( record);
		  pageVo.setRoot(list);
		  pageVo.setTotal(resourcesdao.selectResourcesCount(record));
		  return  pageVo;
	}

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	 public boolean deleteById (  String id ){
		 int flag=resourcesdao.deleteById ( id );
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
	 public boolean deleteResources( Resources record ){
		 int flag=resourcesdao.deleteResources( record );
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
	 public boolean insertResources( Resources record ){
		 int flag=resourcesdao.insertResources( record );
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
	 public boolean updateResources( Resources record ){
		 int flag=resourcesdao.updateResources( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }

}