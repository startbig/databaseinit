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
public class Roles extends Page implements Serializable {

	/****/
	private String id;

	/**角色名称**/
	private String roleName;

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

	public void setRoleName(String roleName){
		this.roleName = roleName;
	}

	public String getRoleName(){
		return this.roleName;
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
