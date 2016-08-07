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
public class Task extends Page implements Serializable {

	/****/
	private String id;

	/**任务内容**/
	private String taskContent;

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

	public void setTaskContent(String taskContent){
		this.taskContent = taskContent;
	}

	public String getTaskContent(){
		return this.taskContent;
	}

	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}

	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}

	public String getCreateUser(){
		return this.createUser;
	}

	

	
	
}
