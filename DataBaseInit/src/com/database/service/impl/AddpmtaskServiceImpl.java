package com.database.service.impl;
import com.database.utils.PageVo;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;
import com.database.service.AddpmtaskService;
import com.database.dao.AddpmtaskDao;
import com.database.po.Addpmtask;

/**
 * 
 * AddpmtaskServiceImpl数据库操作接口类
 * 
 **/

@Service
public class AddpmtaskServiceImpl implements AddpmtaskService{

@Resource
private AddpmtaskDao addpmtaskdao;

	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	 public Addpmtask  selectById (  String id ){
		Addpmtask addpmtask=addpmtaskdao.selectById (id);
		  return addpmtask;
	}

	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
		 public PageVo  selectAddpmtaskList  ( Addpmtask record){
		PageVo  pageVo= new PageVo();
		List<Addpmtask>  list=addpmtaskdao.selectAddpmtaskList( record);
		  pageVo.setRoot(list);
		  pageVo.setTotal(addpmtaskdao.selectAddpmtaskCount(record));
		  return  pageVo;
	}

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	 public boolean deleteById (  String id ){
		 int flag=addpmtaskdao.deleteById ( id );
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
	 public boolean deleteAddpmtask( Addpmtask record ){
		 int flag=addpmtaskdao.deleteAddpmtask( record );
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
	 public boolean insertAddpmtask( Addpmtask record ){
		 int flag=addpmtaskdao.insertAddpmtask( record );
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
	 public boolean updateAddpmtask( Addpmtask record ){
		 int flag=addpmtaskdao.updateAddpmtask( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }

}