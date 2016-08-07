package com.database.service.impl;
import com.database.utils.PageVo;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;
import com.database.service.RoleMenuService;
import com.database.dao.RoleMenuDao;
import com.database.po.RoleMenu;

/**
 * 
 * RoleMenuServiceImpl数据库操作接口类
 * 
 **/

@Service
public class RoleMenuServiceImpl implements RoleMenuService{

@Resource
private RoleMenuDao roleMenudao;

	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	 public RoleMenu  selectById (  String id ){
		RoleMenu roleMenu=roleMenudao.selectById (id);
		  return roleMenu;
	}

	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
		 public PageVo  selectRoleMenuList  ( RoleMenu record){
		PageVo  pageVo= new PageVo();
		List<RoleMenu>  list=roleMenudao.selectRoleMenuList( record);
		  pageVo.setRoot(list);
		  pageVo.setTotal(roleMenudao.selectRoleMenuCount(record));
		  return  pageVo;
	}

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	 public boolean deleteById (  String id ){
		 int flag=roleMenudao.deleteById ( id );
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
	 public boolean deleteRoleMenu( RoleMenu record ){
		 int flag=roleMenudao.deleteRoleMenu( record );
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
	 public boolean insertRoleMenu( RoleMenu record ){
		 int flag=roleMenudao.insertRoleMenu( record );
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
	 public boolean updateRoleMenu( RoleMenu record ){
		 int flag=roleMenudao.updateRoleMenu( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }

}