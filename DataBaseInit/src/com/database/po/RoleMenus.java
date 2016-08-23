package com.database.po;

import java.io.Serializable;

import com.database.utils.Page;


public class RoleMenus extends Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7371300283411115150L;
	//
	private String id;
	//
	private String roleId;
	//
	private String menuId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
	
	
}
