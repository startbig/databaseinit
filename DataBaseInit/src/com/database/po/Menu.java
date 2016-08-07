package com.database.po;
 import java.io.Serializable;

import com.database.utils.Page;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class Menu extends Page implements Serializable {

	/****/
	private String id;

	/**菜单名称**/
	private String menuName;

	/**菜单类型**/
	private String menuType;

	/**父亲id**/
	private String parentId;

	/**创建时间**/
	private java.util.Date createTime;

	/**创建人**/
	private String createUser;
	



	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}


	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

	public void setMenuName(String menuName){
		this.menuName = menuName;
	}

	public String getMenuName(){
		return this.menuName;
	}

	public void setMenuType(String menuType){
		this.menuType = menuType;
	}

	public String getMenuType(){
		return this.menuType;
	}

	public void setParentId(String parentId){
		this.parentId = parentId;
	}

	public String getParentId(){
		return this.parentId;
	}

	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}

	public java.util.Date getCreateTime(){
		return this.createTime;
	}



}
