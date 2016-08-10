package com.database.po;

import java.io.Serializable;

import com.database.utils.Page;


public class UserMenus extends Page implements Serializable{

	//
	private String id;
	//
	private String userId;
	//
	private String menuId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
	
	
}
