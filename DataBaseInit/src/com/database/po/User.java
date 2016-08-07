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
public class User extends Page implements Serializable {

	/****/
	private String id;

	/**姓名**/
	private String userName;

	/**登录名**/
	private String loginName;

	/**邮件地址**/
	private String emailAddress;

	/**用户密码**/
	private String loginPass;

	/**创建时间**/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	private java.util.Date createTime;

	/**创建人**/
	private String createUser;


	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return this.userName;
	}

	public void setLoginName(String loginName){
		this.loginName = loginName;
	}

	public String getLoginName(){
		return this.loginName;
	}

	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress(){
		return this.emailAddress;
	}


	public String getLoginPass() {
		return loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public String getcreateUser() {
		return createUser;
	}

	public void setcreateUser(String createUser) {
		this.createUser = createUser;
	}

}
