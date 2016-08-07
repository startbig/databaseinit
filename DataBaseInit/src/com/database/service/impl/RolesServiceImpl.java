package com.database.service.impl;
import com.database.utils.PageVo;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;
import com.database.service.RolesService;
import com.database.dao.RolesDao;
import com.database.po.Roles;

/**
 * 
 * RolesServiceImpl数据库操作接口类
 * 
 **/

@Service
public class RolesServiceImpl implements RolesService{

@Resource
private RolesDao rolesdao;

	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	 public Roles  selectById (  String id ){
		Roles roles=rolesdao.selectById (id);
		  return roles;
	}

	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
		 public PageVo  selectRolesList  ( Roles record){
		PageVo  pageVo= new PageVo();
		List<Roles>  list=rolesdao.selectRolesList( record);
		  pageVo.setRoot(list);
		  pageVo.setTotal(rolesdao.selectRolesCount(record));
		  return  pageVo;
	}

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	 public boolean deleteById (  String id ){
		 int flag=rolesdao.deleteById ( id );
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
	 public boolean deleteRoles( Roles record ){
		 int flag=rolesdao.deleteRoles( record );
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
	 public boolean insertRoles( Roles record ){
		 int flag=rolesdao.insertRoles( record );
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
	 public boolean updateRoles( Roles record ){
		 int flag=rolesdao.updateRoles( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }
	
}