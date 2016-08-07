package com.database.po;
 import java.util.List;
import java.io.Serializable;

import com.database.utils.Page;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class Resources extends Page implements Serializable {

	/****/
	private String id;

	/**资源名称**/
	private String resourceName;

	/**菜单id**/
	private String menuId;

	/****/
	private String createUser;

	/**资源链接**/
	private String resourceUrl;

	/****/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	private java.util.Date createTime;
	
	private String menuName;



	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

	public void setResourceName(String resourceName){
		this.resourceName = resourceName;
	}

	public String getResourceName(){
		return this.resourceName;
	}

	public void setMenuId(String menuId){
		this.menuId = menuId;
	}

	public String getMenuId(){
		return this.menuId;
	}

	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}

	public String getCreateUser(){
		return this.createUser;
	}

	public void setResourceUrl(String resourceUrl){
		this.resourceUrl = resourceUrl;
	}

	public String getResourceUrl(){
		return this.resourceUrl;
	}

	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}

	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

}
