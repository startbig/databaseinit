package com.database.po;
 import java.util.List;
import java.io.Serializable;
import com.database.utils.Page;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class RoleMenu extends Page implements Serializable {

	/****/
	private String id;

	/**角色id**/
	private String roleId;

	/**菜单id**/
	private String menuId;

	/**创建人**/
	private String createUser;

	/**创建时间**/
	private java.util.Date createTime;



	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

	public void setRoleId(String roleId){
		this.roleId = roleId;
	}

	public String getRoleId(){
		return this.roleId;
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

	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}

	public java.util.Date getCreateTime(){
		return this.createTime;
	}

}
