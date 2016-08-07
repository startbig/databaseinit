package com.database.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.database.dao.MenuDao;
import com.database.po.Menu;
import com.database.service.MenuService;

/**
 * 
 * MenuServiceImpl数据库操作接口类
 * 
 **/

@Service
public class MenuServiceImpl implements MenuService{

@Resource
private MenuDao menudao;

	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	 public Menu  selectById (  String id ){
		Menu menu=menudao.selectById (id);
		  return menu;
	}

	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
		 public List<Menu>  selectMenuList  ( Menu record){
		List<Menu>  list=menudao.selectMenuList( record);
		return  list;
	}

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	 public boolean deleteById (  String id ){
		 int flag=menudao.deleteById ( id );
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
	 public boolean deleteMenu( Menu record ){
		 int flag=menudao.deleteMenu( record );
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
	 public boolean insertMenu( Menu record ){
		 int flag=menudao.insertMenu( record );
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
	 public boolean updateMenu( Menu record ){
		 int flag=menudao.updateMenu( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }

	@Override
	public List<Menu> selectByParentId(String id) {
		// TODO Auto-generated method stub
		List<Menu>  list=menudao.selectByParentId( id);
		return  list;
	}
	
	 public List<Menu>   selectRolesMenus( String id ){
		 List<Menu>  list=menudao.selectRolesMenus( id);
		return list;
	 }

}